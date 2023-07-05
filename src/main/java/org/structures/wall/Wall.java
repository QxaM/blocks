package org.structures.wall;

import org.structures.blocks.Block;
import org.structures.blocks.Brick;
import org.structures.blocks.composites.CompositeBlock;
import org.structures.blocks.composites.CompositeBrick;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {

    private final List<Block> blocks = new ArrayList<>();

    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().contains(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().contains(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        int count = 0;
        for (Block block: blocks) {
            if (block instanceof CompositeBrick) {
                CompositeBlock compositeBlock = (CompositeBrick) block;
                count += compositeBlock.getBlocks().size();
            } else {
                count++;
            }
        }
        return count;
    }
}
