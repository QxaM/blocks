package org.structures.blocks.composites;

import org.structures.blocks.Block;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
