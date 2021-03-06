/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.view.renderer.table;

import be.ugent.maf.cellmissy.gui.view.icon.RectIcon;
import be.ugent.maf.cellmissy.utils.GuiUtils;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderer to be used in a Table: renders a rectangular icon with a colour that
 * depends on the index of the row.
 *
 * @author Paola Masuzzo <paola.masuzzo@ugent.be>
 */
public class RectIconCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int lenght = GuiUtils.getAvailableColors().length;
        int indexOfColor = row % lenght;
        Color color = GuiUtils.getAvailableColors()[indexOfColor];
        setIcon(new RectIcon(color));
        setHorizontalAlignment(SwingConstants.CENTER);
        setText("");
        // we need to specify that the background has to be the same as usually, the default
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        return this;
    }
}
