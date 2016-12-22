package ru.runa.gpd.editor.gef.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class MultiSubprocessFigure extends SubprocessFigure {
    @Override
    public void setBounds(Rectangle rect) {
        if (rect.height < 4 * GRID_SIZE) {
            rect.height = 4 * GRID_SIZE;
        }
        super.setBounds(rect);
    }

    @Override
    protected void paintFigure(Graphics g, Dimension dim) {
        super.paintFigure(g, dim);
        if (!model.isMinimizedView()) {
            Utils.paintSurroudingBoxes(g, dim);
        }
    }

    @Override
    protected Rectangle getFrameArea(Rectangle origin) {
        if (!model.isMinimizedView()) {
            return new Rectangle(origin.x + GRID_SIZE / 2, origin.y, origin.width - GRID_SIZE, origin.height);
        }
        return super.getFrameArea(origin);
    }

}
