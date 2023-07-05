import org.junit.jupiter.api.Test;
import org.structures.blocks.Block;
import org.structures.blocks.Brick;
import org.structures.blocks.composites.CompositeBrick;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeBrickTests {

    private List<Block> initBlocks() {
        Brick brick1 = new Brick("red", "clay");
        Brick brick2 = new Brick("gray", "cement");
        Brick brick3 = new Brick("red", "stone");
        Brick brick4 = new Brick("white", "cement");
        return List.of(brick1, brick2, brick3, brick4);
    }

    @Test
    void testGetColor() {
        //Given
        CompositeBrick compositeBrick = new CompositeBrick();
        compositeBrick.getBlocks().addAll(initBlocks());

        //When
        String foundColors = compositeBrick.getColor();

        //Then
        assertEquals("red, gray, white", foundColors);
    }

    @Test
    void testGetMaterial() {
        //Given
        CompositeBrick compositeBrick = new CompositeBrick();
        compositeBrick.getBlocks().addAll(initBlocks());

        //When
        String foundMaterials = compositeBrick.getMaterial();

        //Then
        assertEquals("clay, cement, stone", foundMaterials);
    }

    @Test
    void testEmptyBlocks() {
        //Given
        CompositeBrick compositeBrick = new CompositeBrick();

        //When
        String foundMaterials = compositeBrick.getMaterial();
        String foundColor = compositeBrick.getColor();

        //Then
        assertAll(() -> assertEquals("", foundMaterials),
                () -> assertEquals("", foundColor));
    }
}
