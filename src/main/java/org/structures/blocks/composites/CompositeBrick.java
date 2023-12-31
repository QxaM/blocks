package org.structures.blocks.composites;

import org.structures.blocks.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeBrick implements CompositeBlock {

    private final List<Block> blocks = new ArrayList<>();

    @Override
    public String getColor() {
        return blocks.stream()
                .map(Block::getColor)
                .distinct()
                .collect(Collectors.joining(", "));
    }

    @Override
    public String getMaterial() {
        return blocks.stream()
                .map(Block::getMaterial)
                .distinct()
                .collect(Collectors.joining(", "));
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(Block::count)
                .sum();
    }
}
