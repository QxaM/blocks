import org.junit.jupiter.api.Test;
import org.structures.block.Block;
import org.structures.block.Brick;
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
}
