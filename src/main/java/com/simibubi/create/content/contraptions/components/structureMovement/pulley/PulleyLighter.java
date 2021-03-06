package com.simibubi.create.content.contraptions.components.structureMovement.pulley;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.contraptions.components.structureMovement.ContraptionLighter;
import com.simibubi.create.foundation.render.backend.light.GridAlignedBB;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PulleyLighter extends ContraptionLighter<PulleyContraption> {
    public PulleyLighter(PulleyContraption contraption) {
        super(contraption);
    }

    @Override
    public GridAlignedBB getContraptionBounds() {

        GridAlignedBB bounds = GridAlignedBB.from(contraption.bounds);

        World world = contraption.entity.world;

        BlockPos.Mutable pos = new BlockPos.Mutable(contraption.anchor);
        while (!AllBlocks.ROPE_PULLEY.has(world.getBlockState(pos)) && pos.getY() < 256) {
            pos.move(0, 1, 0);
        }

        bounds.translate(pos);
        bounds.minY = 1; // the super constructor will take care of making this 0

        return bounds;
    }
}
