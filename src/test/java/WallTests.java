import org.junit.jupiter.api.Test;
import org.structures.blocks.Block;
import org.structures.blocks.Brick;
import org.structures.blocks.composites.CompositeBrick;
import org.structures.wall.Wall;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class WallTests {

    private List<Block> initBlocks() {
        Brick brick1 = new Brick("red", "clay");
        Brick brick2 = new Brick("gray", "cement");
        Brick brick3 = new Brick("red", "stone");
        Brick brick4 = new Brick("white", "cement");
        return List.of(brick1, brick2, brick3, brick4);
    }

    private CompositeBrick initCompositeBlock() {
        CompositeBrick compositeBrick = new CompositeBrick();

        Brick brick1 = new Brick("red", "clay");
        Brick brick2 = new Brick("gray", "cement");
        Brick brick3 = new Brick("red", "stone");
        Brick brick4 = new Brick("white", "cement");

        compositeBrick.getBlocks().addAll(List.of(brick1, brick2, brick3, brick4));
        return compositeBrick;
    }

    private CompositeBrick initNestedCompositeBlock() {
        CompositeBrick compositeBrick = new CompositeBrick();
        compositeBrick.getBlocks().add(initCompositeBlock());
        compositeBrick.getBlocks().addAll(initBlocks());
        return compositeBrick;
    }

    @Test
    void testShouldFindByColor() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().addAll(initBlocks());

        //When
        Optional<Block> foundBlock = wall.findBlockByColor("red");

        //Then
        assertTrue(foundBlock.isPresent());
        assertEquals("red", foundBlock.get().getColor());
    }

    @Test
    void testShouldFindByMaterial() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().addAll(initBlocks());

        //When
        List<Block> foundBlocks = wall.findBlocksByMaterial("cement");

        //Then
        assertAll(() -> assertEquals(2, foundBlocks.size()),
                () -> assertEquals("cement", foundBlocks.get(0).getMaterial()),
                () -> assertEquals("cement", foundBlocks.get(1).getMaterial()));
    }

    @Test
    void testShouldGetCount() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().addAll(initBlocks());

        //When
        int blockCount = wall.count();

        //Then
        assertEquals(4, blockCount);
    }

    @Test
    void testEmptyBlocks() {
        //Given
        Wall wall = new Wall();

        //When
        Optional<Block> foundByColor = wall.findBlockByColor("red");
        List<Block> foundByMaterial = wall.findBlocksByMaterial("cement");
        int count = wall.count();

        //Then
        assertAll(() -> assertTrue(foundByColor.isEmpty()),
                () -> assertTrue(foundByMaterial.isEmpty()),
                () -> assertEquals(0, count));
    }

    @Test
    void testShouldFindByColor_WithCompositeBlocks() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().add(initCompositeBlock());

        //When
        Optional<Block> foundBlock = wall.findBlockByColor("red");

        //Then
        assertTrue(foundBlock.isPresent());
        assertEquals("red, gray, white", foundBlock.get().getColor());
    }

    @Test
    void testShouldFindByMaterial_WithCompositeBlocks() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().add(initCompositeBlock());

        //When
        List<Block> foundBlocks = wall.findBlocksByMaterial("cement");

        //Then
        assertAll(() -> assertEquals(1, foundBlocks.size()),
                () -> assertEquals("clay, cement, stone", foundBlocks.get(0).getMaterial()));
    }

    @Test
    void testShouldGetCount_WithCompositeBlocks() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().add(initCompositeBlock());

        //When
        int blockCount = wall.count();

        //Then
        assertEquals(4, blockCount);
    }

    @Test
    void testShouldFindByColor_WithMixedBlocks() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().add(initNestedCompositeBlock());
        wall.getBlocks().addAll(initBlocks());

        //When
        Optional<Block> foundBlock = wall.findBlockByColor("red");

        //Then
        assertTrue(foundBlock.isPresent());
        assertTrue(foundBlock.get().getColor().contains("red"));
    }

    @Test
    void testShouldFindByMaterial_WithMixedBlocks() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().add(initNestedCompositeBlock());
        wall.getBlocks().addAll(initBlocks());

        //When
        List<Block> foundBlocks = wall.findBlocksByMaterial("cement");

        //Then
        assertEquals(3, foundBlocks.size());
    }

    @Test
    void testShouldGetCount_WithMixedBlocks() {
        //Given
        Wall wall = new Wall();
        wall.getBlocks().add(initNestedCompositeBlock());
        wall.getBlocks().addAll(initBlocks());

        //When
        int blockCount = wall.count();

        //Then
        assertEquals(12, blockCount);
    }
}
