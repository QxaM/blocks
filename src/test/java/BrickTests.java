import org.junit.jupiter.api.Test;
import org.structures.block.Brick;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrickTests {

    @Test
    void testGetColor() {
        //Given
        Brick brick1 = new Brick("red", "clay");
        Brick brick2 = new Brick("gray", "cement");

        //When
        String foundColor1 = brick1.getColor();
        String foundColor2 = brick2.getColor();

        //Then
        assertAll(() -> assertEquals("red", foundColor1),
                () -> assertEquals("gray", foundColor2));
    }

    @Test
    void testGetMaterial() {
        //Given
        Brick brick1 = new Brick("red", "clay");
        Brick brick2 = new Brick("gray", "cement");

        //When
        String foundColor1 = brick1.getColor();
        String foundColor2 = brick2.getColor();

        //Then
        assertAll(() -> assertEquals("red", foundColor1),
                () -> assertEquals("gray", foundColor2));
    }
}
