package org.structures.wall;

import org.structures.blocks.Block;

import java.util.List;
import java.util.Optional;

public interface Structure {
    Optional<Block> findBlockByColor(String color);
    List<Block> findBlocksByMaterial(String material);
    int count();
}
