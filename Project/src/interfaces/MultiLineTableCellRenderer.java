/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import javax.swing.table.*;
import java.util.*;

/**
 *
 * @author Pepito
 */
public class MultiLineTableCellRenderer extends JPanel implements TableCellRenderer {

    private Map<Point, Integer> heightMap = new HashMap<Point, Integer>();
    private ArrayList<TextLayout> textLayoutList = new ArrayList<TextLayout>();
    private String text;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        /* Azzera il "buffer" dei TextLayout */
        textLayoutList.clear();

        /* Ricava la larghezza della colonna corrente */
        TableColumnModel tableColumnModel = table.getColumnModel();
        TableColumn tableColumn = tableColumnModel.getColumn(column);
        int columnWidth = tableColumn.getWidth();

        /* Se il valore è null usiamo come testo un carattere di spaziatura. Altrimenti occorre
ammazzarsi di if perchè AttributedCharacterIterator e TextLayout non vanno d'accordo con null o
con stringhe di lunghezza inferiore a 1 carattere. */
        text = value == null ? " " : (text = String.valueOf(value)).length() == 0 ? " " : text;

        /* Separiamo il testo in linee e calcoliamo nel contempo quale dev'essere l'altezza della
riga per mostrare queste linee. */
        AttributedCharacterIterator styledText = new AttributedString(text).getIterator();
        FontRenderContext fontRenderContext = getFontRenderContext(table);

        /* Senza un FontRenderContext siamo in braghe di tela. */
        if (fontRenderContext != null) {

            /* LineBreakMeasurer è lo strumento che spezza il testo in linee usando una o
più larghezze come limiti per la separazione dei caratteri. */
            LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(styledText, fontRenderContext);

            /* In questo "newHeight" sommeremo l'altezza delle linee di testo e, al termine del
ciclo, verificheremo se sia diverso dall'altezza corrente della riga row. In caso
affermativo useremo newHeight come valore di altezza per la riga row. */
            float newHeight = 0;

            /* LineBreakMeasurer funziona come un iteratore: man mano che gli si chiede di
calcolare quanto testo possa essere disegnato in una certa larghezza avanza di
carattere in carattere. */
            while (lineBreakMeasurer.getPosition() < text.length()) {

                /* La linea di testo che lineBreakMeasurer riesce ad "infilare" in un
certo spazio viene restituita come TextLayout. Per disegnare effettivamente il testo
occorre applicare questo TextLaout ad un Graphics. Noi salviamo la linea di testo
nel buffer "textLayoutList" perchè il momento del disegno è successivo rispetto
all'invocazione del metodo in cui ci troviamo (e passa per paintComponent). */
                TextLayout layout = lineBreakMeasurer.nextLayout(columnWidth);
                textLayoutList.add(layout);

                /* Sommiamo l'altezza della riga appena computata da LineBreakMeasurer all'altezza
totale fin qui ottenuta. Alla fine newHeight sarà la somma delle altezze di tutte
le righe computate da LineBreakMeasurer e ci dirà quanto deva essere alta la riga
della tabella che stiamo esaminando. */
                newHeight += layout.getAscent() + layout.getDescent() + layout.getLeading();
            }

            /* Se l'altezza totale delle linee di testo è maggiore dall'altezza della riga corrente
della tabella allora chiediamo alla tabella di cambiarla. L'invocazione di setRowHeight
causa una nuova richiesta di aggiornamento grafico delle celle contenute in quella riga e,
quindi, una seconda invocazione di questo nostro getTableCellRendererComponent. Probabilmente
qui c'è lo spazio per una qualche ottimizzazione.*/
            int rowHeight = table.getRowHeight(row);
            if ((int) newHeight > rowHeight) {
                int h = Math.round(newHeight);

                /* Salviamo l'altezza della riga nella mappa delle altezze. Useremo poi questa mappa
per determinare quale sia l'altezza della riga nel caso in cui una cella perda
il primato di altezza. */
                heightMap.put(new Point(column, row), h);
                table.setRowHeight(row, h);
            } /* Se l'altezza è minore allora la faccenda si fa più complicata. Questa cella non è più
quella più alta. Dobbiamo determinare quale tra le altre celle contenute nella stessa riga
sia la nuova più alta. */ else if ((int) newHeight < rowHeight) {
                Point cell = new Point();
                cell.y = row;
                int maxHeight = table.getRowHeight();
                for (cell.x = 0; cell.x < table.getColumnCount(); cell.x++) {
                    if (cell.x == column) {
                        heightMap.put(cell, (int) newHeight);
                    }
                    Integer cellHeight = heightMap.get(cell);
                    if (cellHeight == null) {
                        cellHeight = table.getRowHeight();
                    }
                    maxHeight = Math.max(cellHeight, maxHeight);
                }
                if (maxHeight != rowHeight) {
                    table.setRowHeight(row, maxHeight);
                }
            }

            /* Queste righe impostano i colori del componente MultiLineTableCellRenderer in modo
che risulti omogeneo rispetto a quello delle altre celle di table. */
            setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
            setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        }
        return this;
    }

    /* Metodo d'appoggio, estrae un FontRenderContext da un JComponent. La precondizione per
la riuscita dell'operazione è che il componente sia proiettabile (displayable) */
    private FontRenderContext getFontRenderContext(JComponent c) {
        Graphics2D g = (Graphics2D) c.getGraphics();
        return g == null ? null : g.getFontRenderContext();
    }

    /* Questo è il metodo che viene invocato per disegnare concretamente il testo nella
nostra cella. Qui noi usiamo i valori precomputati nel metodo getTableCellRendererComponent. */
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        /* Disegna uno sfondo opaco */
        g.setPaint(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        if (text != null) {
            drawText(text, g);
        }
    }

    private void drawText(String vaue, Graphics2D g) {
        g.setPaint(getForeground());

        /* Ogni TextLayout contenuto in textLayoutList rappresenta una linea di
testo "creata" dal LineBreakMeasurer nel metodo getTableCellRendererComponent. Qui
disegnamo quelle linee una sotto l'altra. */
        Point2D.Float pen = new Point2D.Float();
        for (TextLayout layout : textLayoutList) {
            pen.y += layout.getAscent();
            layout.draw(g, pen.x, pen.y);
            pen.y += layout.getDescent() + layout.getLeading();
        }
    }
}
