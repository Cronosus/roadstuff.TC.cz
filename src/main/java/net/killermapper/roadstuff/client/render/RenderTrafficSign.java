/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015-2016

The MIT License (MIT)

Copyright (c) 2015-2016 KillerMapper

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package net.killermapper.roadstuff.client.render;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.killermapper.roadstuff.common.tiles.TileEntityBlockTrafficSign;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class RenderTrafficSign implements ISimpleBlockRenderingHandler
{
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        Tessellator tessellator = Tessellator.instance;

        renderer.setRenderBounds(7 / 16F, 0.0F, 9 / 16F, 9 / 16F, 1F, 10 / 16F);
        this.renderInInventory(tessellator, renderer, block, metadata);
        renderer.setRenderBounds(7 / 16F, 0.0F, 0.5F, 7.5 / 16F, 1F, 10 / 16F);
        this.renderInInventory(tessellator, renderer, block, metadata);
        renderer.setRenderBounds(8.5 / 16F, 0.0F, 0.5F, 9 / 16F, 1F, 10 / 16F);
        this.renderInInventory(tessellator, renderer, block, metadata);

        if(metadata == 1)
        {
            renderer.setRenderBounds(5 / 16F, 0.0F, 10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(0.0F, 5 / 16F, 10 / 16F, 1F, 11 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
            renderer.setRenderBounds(5 / 16F, 15 / 16F, 10 / 16F, 11 / 16F, 1F, 11 / 16F);
            this.renderInInventory(tessellator, renderer, block, metadata);
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityBlockTrafficSign)
        {
            TileEntityBlockTrafficSign tileSign = (TileEntityBlockTrafficSign)tile;

            GL11.glPushMatrix();

            // Direction
            byte signTop = 16;

            if(tileSign.getSignType() > 45 && tileSign.getSignType() < 62 && tileSign.getSignShape() == 5)
            {
                signTop = 8;
            }

            switch(tileSign.getSignDirection())
            {
                case 0:

                    renderer.setRenderBounds(7 / 16F, 0 / 16F, 9 / 16F, 9 / 16F, signTop / 16F, 10 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0 / 16F, 0.5F, 0.46875F, signTop / 16F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(0.53125F, 0 / 16F, 0.5F, 9 / 16F, signTop / 16F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:  //ctverec
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1:  //kruh
                                renderer.setRenderBounds(5 / 16F, 0.0F, 10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 5 / 16F, 10 / 16F, 1F, 11 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 10 / 16F, 11 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:  //trojuhelnik
                                renderer.setRenderBounds(1 / 16F, 0.0F, 10 / 16F, 15 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 1 / 16F, 10 / 16F, 1F, 4 /16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 4 / 16F, 10 / 16F, 15 / 16F, 6 / 16F, 11 / 16F); 
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 6 / 16F, 10 / 16F, 14 /16F, 0.5F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 8 / 16F, 10 / 16F, 13 / 16F, 10 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(4 / 16F, 10 / 16F, 10 / 16F, 12 / 16F, 12 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 10 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 14 / 16F, 10 / 16F, 10 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:  //diamant
                                renderer.setRenderBounds(7 / 16F, 0.0F, 10 / 16F, 9 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 1 / 16F, 10 / 16F, 10 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 2 / 16F, 10 / 16F, 11 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(4 / 16F, 3 / 16F, 10 / 16F, 12 / 16F, 0.25F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 0.25F, 10 / 16F, 13 / 16F, 5 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 5 / 16F, 10 / 16F, 14 / 16F, 6 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 6 / 16F, 10 / 16F, 15 / 16F, 7 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 7 / 16F, 10 / 16F, 1F, 9 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 9 / 16F, 10 / 16F, 15 / 16F, 10 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 10 / 16F, 10 / 16F, 14 / 16F, 11 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 11 / 16F, 10 / 16F, 13 / 16F, 12 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(4 / 16F, 12 / 16F, 10 / 16F, 12 / 16F, 13 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 13 / 16F, 10 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 14 / 16F, 10 / 16F, 10 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(7 / 16F, 15 / 16F, 10 / 16F, 9 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 4:  //obdelnik -2
                                renderer.setRenderBounds(2 / 16F, 0.0F, 10 / 16F, 14 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 5:
                                if(tileSign.getSignType() == 1 && tileSign.getSignShape() == 5)  //STOP
                                {                        
                                    renderer.setRenderBounds(4 / 16F, 0.0F, 10 / 16F, 12 / 16F, 1 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 4 / 16F, 10 / 16F, 1F, 12 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 16F, 15 / 16F, 10 / 16F, 12 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 1 && tileSign.getSignType() < 4 && tileSign.getSignShape() == 5)  //obraceny trojuhelnik
                                {                        
                                    renderer.setRenderBounds(1 / 16F, 15 / 16F, 10 / 16F, 15 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 12 / 16F, 10 / 16F, 1F, 15 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 10 / 16F, 10 / 16F, 15 / 16F, 12 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 8 / 16F, 10 / 16F, 14 / 16F, 10 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 6 / 16F, 10 / 16F, 13 / 16F, 8 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 16F, 4 / 16F, 10 / 16F, 12 / 16F, 6 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 10 / 16F, 11 / 16F, 4 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 16F, 0.0F, 10 / 16F, 10 / 16F, 2 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 3 && tileSign.getSignType() < 46 && tileSign.getSignShape() == 5)  //pulka nahore
                                {                        
                                    renderer.setRenderBounds(1 / 16F, 8 / 16F, 10 / 16F, 15 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 45 && tileSign.getSignType() < 62 && tileSign.getSignShape() == 5)  //pulka dole
                                {                        
                                renderer.setRenderBounds(1 / 16F, 0.0F, 10 / 16F, 15 / 16F, 8 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 62 && tileSign.getSignShape() == 5)  //bocni trojuhelnik
                                {                        
                                    renderer.setRenderBounds(0.0F, 1 / 32F, 10 / 16F, 1 / 32F, 31 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 0.0F, 10 / 16F, 3 / 32F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 1 / 32F, 10 / 16F, 5 / 32F, 31 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 2 / 32F, 10 / 16F, 7 / 32F, 30 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 3 / 32F, 10 / 16F, 9 / 32F, 29 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 4 / 32F, 10 / 16F, 11 / 32F, 28 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(11 / 32F, 5 / 32F, 10 / 16F, 13 / 32F, 27 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(13 / 32F, 6 / 32F, 10 / 16F, 15 / 32F, 26 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(15 / 32F, 7 / 32F, 10 / 16F, 17 / 32F, 25 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 8 / 32F, 10 / 16F, 19 / 32F, 24 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 9 / 32F, 10 / 16F, 21 / 32F, 23 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 10 / 32F, 10 / 16F, 23 / 32F, 22 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 11 / 32F, 10 / 16F, 25 / 32F, 21 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 12 / 32F, 10 / 16F, 27 / 32F, 20 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(27 / 32F, 13 / 32F, 10 / 16F, 29 / 32F, 19 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(29 / 32F, 14 / 32F, 10 / 16F, 31 / 32F, 18 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(31 / 32F, 15 / 32F, 10 / 16F, 1F, 17 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 62 && tileSign.getSignType() < 76 && tileSign.getSignShape() == 5)  //-4 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(4 / 16F, 0.0F, 10 / 16F, 12 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 6:
                                /*  //pismo bez pozadi nejde*/
                                if(tileSign.getSignType() > 72 && tileSign.getSignType() < 145 && tileSign.getSignShape() == 6)  //vyplnene pismo ctverec
                                {                        
                                    renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 7:
                                if(tileSign.getSignType() >= 1 && tileSign.getSignType() < 7 && tileSign.getSignShape() == 7)  //kriz 1
                                {                        
                                    renderer.setRenderBounds(2 / 32F, 6 / 32F, 10 / 16F, 7 / 32F, 7 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 6 / 32F, 10 / 16F, 30 / 32F, 7 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 7 / 32F, 10 / 16F, 9 / 32F, 8 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 7 / 32F, 10 / 16F, 30 / 32F, 8 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 8 / 32F, 10 / 16F, 10 / 32F, 9 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 8 / 32F, 10 / 16F, 30 / 32F, 9 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 9 / 32F, 10 / 16F, 12 / 32F, 10 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 9 / 32F, 10 / 16F, 30 / 32F, 10 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 10 / 32F, 10 / 16F, 13 / 32F, 11 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 10 / 32F, 10 / 16F, 29 / 32F, 11 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 11 / 32F, 10 / 16F, 15 / 32F, 12 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 11 / 32F, 10 / 16F, 28 / 32F, 12 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 12 / 32F, 10 / 16F, 26 / 32F, 13 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 13 / 32F, 10 / 16F, 25 / 32F, 14 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 14 / 32F, 10 / 16F, 23 / 32F, 15 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 15 / 32F, 10 / 16F, 22 / 32F, 17 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 17 / 32F, 10 / 16F, 23 / 32F, 18 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 18 / 32F, 10 / 16F, 25 / 32F, 19 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 19 / 32F, 10 / 16F, 26 / 32F, 20 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 20 / 32F, 10 / 16F, 15 / 32F, 21 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 20 / 32F, 10 / 16F, 28 / 32F, 21 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 21 / 32F, 10 / 16F, 13 / 32F, 22 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 21 / 32F, 10 / 16F, 29 / 32F, 22 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 22 / 32F, 10 / 16F, 12 / 32F, 23 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 22 / 32F, 10 / 16F, 30 / 32F, 23 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 23 / 32F, 10 / 16F, 10 / 32F, 24 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 23 / 32F, 10 / 16F, 30 / 32F, 24 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 24 / 32F, 10 / 16F, 9 / 32F, 25 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 24 / 32F, 10 / 16F, 30 / 32F, 25 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 25 / 32F, 10 / 16F, 7 / 32F, 26 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 25 / 32F, 10 / 16F, 30 / 32F, 26 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 6 && tileSign.getSignType() < 9 && tileSign.getSignShape() == 7)  //kriz 2
                                {                        
                                    renderer.setRenderBounds(5 / 32F, 0.0F, 10 / 16F, 6 / 32F, 1 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(26 / 32F, 0.0F, 10 / 16F, 27 / 32F, 1 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 1 / 32F, 10 / 16F, 7 / 32F, 2 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 1 / 32F, 10 / 16F, 28 / 32F, 2 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 2 / 32F, 10 / 16F, 8 / 32F, 3 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(24 / 32F, 2 / 32F, 10 / 16F, 29 / 32F, 3 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 3 / 32F, 10 / 16F, 9 / 32F, 4 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 3 / 32F, 10 / 16F, 30 / 32F, 4 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 4 / 32F, 10 / 16F, 10 / 32F, 5 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 4 / 32F, 10 / 16F, 31 / 32F, 5 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 5 / 32F, 10 / 16F, 11 / 32F, 6 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 5 / 32F, 10 / 16F, 1F, 6 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 6 / 32F, 10 / 16F, 12 / 32F, 7 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 6 / 32F, 10 / 16F, 31 / 32F, 7 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 7 / 32F, 10 / 16F, 13 / 32F, 8 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 7 / 32F, 10 / 16F, 30 / 32F, 8 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 8 / 32F, 10 / 16F, 14 / 32F, 9 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(18 / 32F, 8 / 32F, 10 / 16F, 29 / 32F, 9 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 9 / 32F, 10 / 16F, 15 / 32F, 10 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 9 / 32F, 10 / 16F, 28 / 32F, 10 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 10 / 32F, 10 / 16F, 27 / 32F, 11 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 11 / 32F, 10 / 16F, 26 / 32F, 12 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 12 / 32F, 10 / 16F, 25 / 32F, 13 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 13 / 32F, 10 / 16F, 24 / 32F, 14 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 14 / 32F, 10 / 16F, 23 / 32F, 15 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 15 / 32F, 10 / 16F, 22 / 32F, 17 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 17 / 32F, 10 / 16F, 23 / 32F, 18 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 18 / 32F, 10 / 16F, 24 / 32F, 19 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 19 / 32F, 10 / 16F, 25 / 32F, 20 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 20 / 32F, 10 / 16F, 26 / 32F, 21 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 21 / 32F, 10 / 16F, 27 / 32F, 22 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 22 / 32F, 10 / 16F, 15 / 32F, 23 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 22 / 32F, 10 / 16F, 28 / 32F, 23 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 23 / 32F, 10 / 16F, 14 / 32F, 24 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(18 / 32F, 23 / 32F, 10 / 16F, 29 / 32F, 24 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 24 / 32F, 10 / 16F, 13 / 32F, 25 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 24 / 32F, 10 / 16F, 30 / 32F, 25 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 25 / 32F, 10 / 16F, 12 / 32F, 26 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 25 / 32F, 10 / 16F, 31 / 32F, 26 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 26 / 32F, 10 / 16F, 11 / 32F, 27 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 26 / 32F, 10 / 16F, 1F, 27 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 27 / 32F, 10 / 16F, 10 / 32F, 28 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 27 / 32F, 10 / 16F, 31 / 32F, 28 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 28 / 32F, 10 / 16F, 9 / 32F, 29 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 28 / 32F, 10 / 16F, 30 / 32F, 29 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 29 / 32F, 10 / 16F, 8 / 32F, 30 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(24 / 32F, 29 / 32F, 10 / 16F, 29 / 32F, 30 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 30 / 32F, 10 / 16F, 7 / 32F, 31 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 30 / 32F, 10 / 16F, 28 / 32F, 31 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 31 / 32F, 10 / 16F, 6 / 32F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(26 / 32F, 31 / 32F, 10 / 16F, 27 / 32F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);

                                    break;
                                }
                                /*if(tileSign.getSignType() == 9 && tileSign.getSignShape() == 7)  //kriz 3
                                {                        
                                }*/
                                if(tileSign.getSignType() > 9 && tileSign.getSignType() < 23 && tileSign.getSignShape() == 7)  //-4 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(4 / 16F, 0.0F, 10 / 16F, 12 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 22 && tileSign.getSignType() < 43 && tileSign.getSignShape() == 7)  //diamant
                                {                        
                                    renderer.setRenderBounds(7 / 16F, 0.0F, 10 / 16F, 9 / 16F, 1 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 16F, 1 / 16F, 10 / 16F, 10 / 16F, 2 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 10 / 16F, 11 / 16F, 3 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 16F, 3 / 16F, 10 / 16F, 12 / 16F, 0.25F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 0.25F, 10 / 16F, 13 / 16F, 5 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 5 / 16F, 10 / 16F, 14 / 16F, 6 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 6 / 16F, 10 / 16F, 15 / 16F, 7 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 7 / 16F, 10 / 16F, 1F, 9 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 9 / 16F, 10 / 16F, 15 / 16F, 10 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 10 / 16F, 10 / 16F, 14 / 16F, 11 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 11 / 16F, 10 / 16F, 13 / 16F, 12 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 16F, 12 / 16F, 10 / 16F, 12 / 16F, 13 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 16F, 10 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 16F, 14 / 16F, 10 / 16F, 10 / 16F, 15 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 16F, 15 / 16F, 10 / 16F, 9 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 42 && tileSign.getSignType() < 54 && tileSign.getSignShape() == 7)  //ctverec
                                {                        
                                    renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 54 && tileSign.getSignShape() == 7)  //sipka dolu
                                {                        
                                    renderer.setRenderBounds(15 / 32F, 1 / 32F, 10 / 16F, 17 / 32F, 2 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(14 / 32F, 2 / 32F, 10 / 16F, 18 / 32F, 3 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(13 / 32F, 3 / 32F, 10 / 16F, 19 / 32F, 4 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(12 / 32F, 4 / 32F, 10 / 16F, 20 / 32F, 5 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(11 / 32F, 5 / 32F, 10 / 16F, 21 / 32F, 6 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 6 / 32F, 10 / 16F, 22 / 32F, 7 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 7 / 32F, 10 / 16F, 23 / 32F, 8 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 8 / 32F, 10 / 16F, 24 / 32F, 9 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 9 / 32F, 10 / 16F, 25 / 32F, 10 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 10 / 32F, 10 / 16F, 26 / 32F, 11 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 11 / 32F, 10 / 16F, 27 / 32F, 12 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 12 / 32F, 10 / 16F, 28 / 32F, 13 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 13 / 32F, 10 / 16F, 29 / 32F, 14 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 14 / 32F, 10 / 16F, 30 / 32F, 15 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 15 / 32F, 10 / 16F, 31 / 32F, 16 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 16 / 32F, 10 / 16F, 1F, 21 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 21 / 32F, 10 / 16F, 26 / 32F, 26 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 26 / 32F, 10 / 16F, 26 / 32F, 27 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 26 / 32F, 10 / 16F, 15 / 32F, 27 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(18 / 32F, 27 / 32F, 10 / 16F, 26 / 32F, 28 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 27 / 32F, 10 / 16F, 14 / 32F, 28 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 28 / 32F, 10 / 16F, 26 / 32F, 29 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 28 / 32F, 10 / 16F, 13 / 32F, 29 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 29 / 32F, 10 / 16F, 26 / 32F, 30 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 29 / 32F, 10 / 16F, 12 / 32F, 30 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 30 / 32F, 10 / 16F, 26 / 32F, 31 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 30 / 32F, 10 / 16F, 11 / 32F, 31 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 31 / 32F, 10 / 16F, 26 / 32F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 31 / 32F, 10 / 16F, 10 / 32F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 55 && tileSign.getSignShape() == 7)  //sipka M dolu
                                {                        
                                    renderer.setRenderBounds(0.0F, 22 / 32F, 10 / 16F, 1F, 25 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 21 / 32F, 10 / 16F, 31 / 32F, 22 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 20 / 32F, 10 / 16F, 30 / 32F, 21 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 19 / 32F, 10 / 16F, 29 / 32F, 20 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 18 / 32F, 10 / 16F, 28 / 32F, 19 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 17 / 32F, 10 / 16F, 27 / 32F, 18 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 16 / 32F, 10 / 16F, 26 / 32F, 17 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 15 / 32F, 10 / 16F, 25 / 32F, 16 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 14 / 32F, 10 / 16F, 24 / 32F, 15 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 13 / 32F, 10 / 16F, 23 / 32F, 14 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 12 / 32F, 10 / 16F, 22 / 32F, 13 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(11 / 32F, 11 / 32F, 10 / 16F, 21 / 32F, 12 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(12 / 32F, 10 / 32F, 10 / 16F, 20 / 32F, 11 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(13 / 32F, 9 / 32F, 10 / 16F, 19 / 32F, 10 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(14 / 32F, 8 / 32F, 10 / 16F, 18 / 32F, 9 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(15 / 32F, 7 / 32F, 10 / 16F, 17 / 32F, 8 / 32F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 55 && tileSign.getSignType() < 60 && tileSign.getSignShape() == 7)  //kruh
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 5 / 16F, 10 / 16F, 1F, 11 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 10 / 16F, 11 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 60 && tileSign.getSignShape() == 7)  //pulka uprostred
                                {                        
                                    renderer.setRenderBounds(0.0F, 4 / 16F, 10 / 16F, 1F, 12 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 61 && tileSign.getSignShape() == 7)  //-3 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(3 / 16F, 0.0F, 10 / 16F, 13 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 61 && tileSign.getSignShape() == 7) //-2 uzky obdelnik
                                {
                                    renderer.setRenderBounds(2 / 16F, 0.0F, 10 / 16F, 14 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 8:
                                if(tileSign.getSignType() > 0 && tileSign.getSignType() < 69 && tileSign.getSignShape() == 8)  //kruh
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 5 / 16F, 10 / 16F, 1F, 11 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 10 / 16F, 11 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 68 && tileSign.getSignType() < 137 && tileSign.getSignShape() == 8)  //ctverec
                                {                        
                                    renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                         }
                    }
                    break;
                case 1:

                    renderer.setRenderBounds(6 / 16F, 0.0F, 7 / 16F, 7 / 16F, signTop / 16F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 7 / 16F, 0.5F, signTop / 16F, 0.48F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 0.525F, 0.5F, signTop / 16F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:  //ctverec
                                renderer.setRenderBounds(5 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1: //kruh
                                renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 16F, 6 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 3 / 16F, 6 / 16F, 2 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 2 / 16F, 2 / 16F, 6 / 16F, 3 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 3 / 16F, 1 / 16F, 6 / 16F, 5 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 5 / 16F, 0.0F, 6 / 16F, 11 / 16F, 16 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F, 13 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F, 14 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F, 15 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:  //trojuhelnik
                                renderer.setRenderBounds(5 / 16F, 0.0F, 1 / 16F, 6 / 16F, 1 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 0.0F, 6 / 16F, 4 / 16F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 4 / 16F, 1 / 16F, 6 / 16F, 6 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 6 / 16F, 2 / 16F, 6 / 16F, 8 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 8 / 16F, 3 / 16F, 6 / 16F, 10 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 10 / 16F, 4 / 16F, 6 / 16F, 12 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 5 / 16F, 6 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 6 / 16F, 6 / 16F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:  //diamant
                                renderer.setRenderBounds(5 / 16F, 0.0F, 7 / 16F, 6 / 16F, 1 / 16F, 9 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 6 / 16F, 6 / 16F, 2 / 16F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 2 / 16F, 5 / 16F, 6 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 3 / 16F, 4 / 16F, 6 / 16F, 4 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 4 / 16F, 3 / 16F, 6 / 16F, 5 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 5 / 16F, 2 / 16F, 6 / 16F, 6 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 6 / 16F, 1 / 16F, 6 / 16F, 7 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 7 / 16F, 0.0F, 6 / 16F, 9 / 16F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 9 / 16F, 1 / 16F, 6 / 16F, 10 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 10 / 16F, 2 / 16F, 6 / 16F, 11 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 11 / 16F, 3 / 16F, 6 / 16F, 12 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 4 / 16F, 6 / 16F, 13 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 13 / 16F, 5 / 16F, 6 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 6 / 16F, 6 / 16F, 15 / 16F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 7 / 16F, 6 / 16F, 1F, 9 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 4:  //obdelnik -2
                                renderer.setRenderBounds(5 / 16F, 0.0F, 2 / 16F, 6 / 16F, 1F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 5:
                                if(tileSign.getSignType() == 1 && tileSign.getSignShape() == 5)  //STOP
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 4 / 16F, 6 / 16F, 1 / 16F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 1 / 16F, 3 / 16F, 6 / 16F, 2 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 2 / 16F, 6 / 16F, 3 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 3 / 16F, 1 / 16F, 6 / 16F, 5 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 4 / 16F, 0.0F, 6 / 16F, 12 / 16F, 16 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F, 13 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F, 14 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F, 15 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 4 / 16F, 6 / 16F, 1F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 1 && tileSign.getSignType() < 4 && tileSign.getSignShape() == 5)  //obraceny trojuhelnik
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 1 / 16F, 6 / 16F, 1F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 12 / 16F, 0.0F, 6 / 16F, 15 / 16F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 10 / 16F, 1 / 16F, 6 / 16F, 12 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 8 / 16F, 2 / 16F, 6 / 16F, 10 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 6 / 16F, 3 / 16F, 6 / 16F, 8 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 4 / 16F, 4 / 16F, 6 / 16F, 6 / 16F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 5 / 16F, 6 / 16F, 4 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 6 / 16F, 6 / 16F, 2 / 16F, 10 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 3 && tileSign.getSignType() < 46 && tileSign.getSignShape() == 5)  //pulka nahore
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 8 / 16F, 1 / 16F, 6 / 16F, 1F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 45 && tileSign.getSignType() < 62 && tileSign.getSignShape() == 5)  //pulka dole
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 1 / 16F, 6 / 16F, 8 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 62 && tileSign.getSignShape() == 5)  //bocni trojuhelnik
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 1 / 32F, 0.0F, 6 / 16F, 31 / 32F, 1 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 1 / 32F, 6 / 16F, 1F, 3 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 1 / 32F, 3 / 32F, 6 / 16F, 31 / 32F, 5 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 32F, 5 / 32F, 6 / 16F, 30 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 3 / 32F, 7 / 32F, 6 / 16F, 29 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 4 / 32F, 9 / 32F, 6 / 16F, 28 / 32F, 11 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 5 / 32F, 11 / 32F, 6 / 16F, 27 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 6 / 32F, 13 / 32F, 6 / 16F, 26 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 7 / 32F, 15 / 32F, 6 / 16F, 25 / 32F, 17 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 8 / 32F, 17 / 32F, 6 / 16F, 24 / 32F, 19 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 9 / 32F, 19 / 32F, 6 / 16F, 23 / 32F, 21 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 10 / 32F, 21 / 32F, 6 / 16F, 22 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 32F, 23 / 32F, 6 / 16F, 21 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 12 / 32F, 25 / 32F, 6 / 16F, 20 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 32F, 27 / 32F, 6 / 16F, 19 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 32F, 29 / 32F, 6 / 16F, 18 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 32F, 31 / 32F, 6 / 16F, 17 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 62 && tileSign.getSignType() < 76 && tileSign.getSignShape() == 5)  //-4 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 4 / 16F, 6 / 16F, 1F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(6 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 6:
                                /*  //pismo bez pozadi nejde*/
                                if(tileSign.getSignType() > 72 && tileSign.getSignType() < 145 && tileSign.getSignShape() == 6)  //ctverec
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(6 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 7:
                                if(tileSign.getSignType() >= 1 && tileSign.getSignType() < 7 && tileSign.getSignShape() == 7)  //kriz 1
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 6 / 32F, 2 / 32F, 6 / 16F, 7 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 6 / 32F, 25 / 32F, 6 / 16F, 7 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 7 / 32F, 2 / 32F, 6 / 16F, 8 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 7 / 32F, 23 / 32F, 6 / 16F, 8 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 8 / 32F, 2 / 32F, 6 / 16F, 9 / 32F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 8 / 32F, 22 / 32F, 6 / 16F, 9 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 9 / 32F, 2 / 32F, 6 / 16F, 10 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 9 / 32F, 20 / 32F, 6 / 16F, 10 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 10 / 32F, 3 / 32F, 6 / 16F, 11 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 10 / 32F, 19 / 32F, 6 / 16F, 11 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 32F, 4 / 32F, 6 / 16F, 12 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 32F, 17 / 32F, 6 / 16F, 12 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 12 / 32F, 6 / 32F, 6 / 16F, 13 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 32F, 7 / 32F, 6 / 16F, 14 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 32F, 9 / 32F, 6 / 16F, 15 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 32F, 10 / 32F, 6 / 16F, 17 / 32F, 22 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 17 / 32F, 9 / 32F, 6 / 16F, 18 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 18 / 32F, 7 / 32F, 6 / 16F, 19 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 19 / 32F, 6 / 32F, 6 / 16F, 20 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 20 / 32F, 4 / 32F, 6 / 16F, 21 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 20 / 32F, 17 / 32F, 6 / 16F, 21 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 21 / 32F, 3 / 32F, 6 / 16F, 22 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 21 / 32F, 19 / 32F, 6 / 16F, 22 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 22 / 32F, 2 / 32F, 6 / 16F, 23 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 22 / 32F, 20 / 32F, 6 / 16F, 23 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 23 / 32F, 2 / 32F, 6 / 16F, 24 / 32F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 23 / 32F, 22 / 32F, 6 / 16F, 24 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 24 / 32F, 2 / 32F, 6 / 16F, 25 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 24 / 32F, 23 / 32F, 6 / 16F, 25 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 25 / 32F, 2 / 32F, 6 / 16F, 26 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 25 / 32F, 25 / 32F, 6 / 16F, 26 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 6 && tileSign.getSignType() < 9 && tileSign.getSignShape() == 7)  //kriz 2
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 32F, 6 / 16F, 1 / 32F, 6 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 26 / 32F, 6 / 16F, 1 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 1 / 32F, 4 / 32F, 6 / 16F, 2 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 1 / 32F, 25 / 32F, 6 / 16F, 2 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 32F, 3 / 32F, 6 / 16F, 3 / 32F, 8 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 32F, 24 / 32F, 6 / 16F, 3 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 3 / 32F, 2 / 32F, 6 / 16F, 4 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 3 / 32F, 23 / 32F, 6 / 16F, 4 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 4 / 32F, 1 / 32F, 6 / 16F, 5 / 32F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 4 / 32F, 22 / 32F, 6 / 16F, 5 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 5 / 32F, 0.0F, 6 / 16F, 6 / 32F, 11 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 5 / 32F, 21 / 32F, 6 / 16F, 6 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 6 / 32F, 1 / 32F, 6 / 16F, 7 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 6 / 32F, 20 / 32F, 6 / 16F, 7 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 7 / 32F, 2 / 32F, 6 / 16F, 8 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 7 / 32F, 19 / 32F, 6 / 16F, 8 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 8 / 32F, 3 / 32F, 6 / 16F, 9 / 32F, 14 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 8 / 32F, 18 / 32F, 6 / 16F, 9 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 9 / 32F, 4 / 32F, 6 / 16F, 10 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 9 / 32F, 17 / 32F, 6 / 16F, 10 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 10 / 32F, 5 / 32F, 6 / 16F, 11 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 32F, 6 / 32F, 6 / 16F, 12 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 12 / 32F, 7 / 32F, 6 / 16F, 13 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 32F, 8 / 32F, 6 / 16F, 14 / 32F, 24 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 32F, 9 / 32F, 6 / 16F, 15 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 32F, 10 / 32F, 6 / 16F, 17 / 32F, 22 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 17 / 32F, 9 / 32F, 6 / 16F, 18 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 18 / 32F, 8 / 32F, 6 / 16F, 19 / 32F, 24 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 19 / 32F, 7 / 32F, 6 / 16F, 20 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 20 / 32F, 6 / 32F, 6 / 16F, 21 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 21 / 32F, 5 / 32F, 6 / 16F, 22 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 22 / 32F, 4 / 32F, 6 / 16F, 23 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 22 / 32F, 17 / 32F, 6 / 16F, 23 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 23 / 32F, 3 / 32F, 6 / 16F, 24 / 32F, 14 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 23 / 32F, 18 / 32F, 6 / 16F, 24 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 24 / 32F, 2 / 32F, 6 / 16F, 25 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 24 / 32F, 19 / 32F, 6 / 16F, 25 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 25 / 32F, 1 / 32F, 6 / 16F, 26 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 25 / 32F, 20 / 32F, 6 / 16F, 26 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 26 / 32F, 0.0F, 6 / 16F, 27 / 32F, 11 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 26 / 32F, 21 / 32F, 6 / 16F, 27 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 27 / 32F, 1 / 32F, 6 / 16F, 28 / 32F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 27 / 32F, 22 / 32F, 6 / 16F, 28 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 28 / 32F, 2 / 32F, 6 / 16F, 29 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 28 / 32F, 23 / 32F, 6 / 16F, 29 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 29 / 32F, 3 / 32F, 6 / 16F, 30 / 32F, 8 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 29 / 32F, 24 / 32F, 6 / 16F, 30 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 30 / 32F, 4 / 32F, 6 / 16F, 31 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 30 / 32F, 25 / 32F, 6 / 16F, 31 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 31 / 32F, 5 / 32F, 6 / 16F, 1F, 6 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 31 / 32F, 26 / 32F, 6 / 16F, 1F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                /*if(tileSign.getSignType() == 9 && tileSign.getSignShape() == 7)  //kriz 3
                                {                        
                                }*/
                                if(tileSign.getSignType() > 9 && tileSign.getSignType() < 23 && tileSign.getSignShape() == 7)  //-4 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 4 / 16F, 6 / 16F, 1F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 22 && tileSign.getSignType() < 43 && tileSign.getSignShape() == 7)  //diamant
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 7 / 16F, 6 / 16F, 1 / 16F, 9 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 1 / 16F, 6 / 16F, 6 / 16F, 2 / 16F, 10 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 5 / 16F, 6 / 16F, 3 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 3 / 16F, 4 / 16F, 6 / 16F, 4 / 16F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 4 / 16F, 3 / 16F, 6 / 16F, 5 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 5 / 16F, 2 / 16F, 6 / 16F, 6 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 6 / 16F, 1 / 16F, 6 / 16F, 7 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 7 / 16F, 0.0F, 6 / 16F, 9 / 16F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 9 / 16F, 1 / 16F, 6 / 16F, 10 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 10 / 16F, 2 / 16F, 6 / 16F, 11 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 16F, 3 / 16F, 6 / 16F, 12 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 12 / 16F, 4 / 16F, 6 / 16F, 13 / 16F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 16F, 5 / 16F, 6 / 16F, 14 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 16F, 6 / 16F, 6 / 16F, 15 / 16F, 10 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 7 / 16F, 6 / 16F, 1F, 9 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 42 && tileSign.getSignType() < 54 && tileSign.getSignShape() == 7)  //ctverec
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 54 && tileSign.getSignShape() == 7)  //sipka dolu
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 1 / 32F, 15 / 32F, 6 / 16F, 2 / 32F, 17 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 32F, 14 / 32F, 6 / 16F, 3 / 32F, 18 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 3 / 32F, 13 / 32F, 6 / 16F, 4 / 32F, 19 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 4 / 32F, 12 / 32F, 6 / 16F, 5 / 32F, 20 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 5 / 32F, 11 / 32F, 6 / 16F, 6 / 32F, 21 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 6 / 32F, 10 / 32F, 6 / 16F, 7 / 32F, 22 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 7 / 32F, 9 / 32F, 6 / 16F, 8 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 8 / 32F, 8 / 32F, 6 / 16F, 9 / 32F, 24 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 9 / 32F, 7 / 32F, 6 / 16F, 10 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 10 / 32F, 6 / 32F, 6 / 16F, 11 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 32F, 5 / 32F, 6 / 16F, 12 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 12 / 32F, 4 / 32F, 6 / 16F, 13 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 32F, 3 / 32F, 6 / 16F, 14 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 32F, 2 / 32F, 6 / 16F, 15 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 32F, 1 / 32F, 6 / 16F, 16 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 16 / 32F, 0.0F, 6 / 16F, 21 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 21 / 32F, 6 / 32F, 6 / 16F, 26 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 26 / 32F, 17 / 32F, 6 / 16F, 27 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 26 / 32F, 6 / 32F, 6 / 16F, 27 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 27 / 32F, 18 / 32F, 6 / 16F, 28 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 27 / 32F, 6 / 32F, 6 / 16F, 28 / 32F, 14 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 28 / 32F, 19 / 32F, 6 / 16F, 29 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 28 / 32F, 6 / 32F, 6 / 16F, 29 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 29 / 32F, 20 / 32F, 6 / 16F, 30 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 29 / 32F, 6 / 32F, 6 / 16F, 30 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 30 / 32F, 21 / 32F, 6 / 16F, 31 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 30 / 32F, 6 / 32F, 6 / 16F, 31 / 32F, 11 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 31 / 32F, 22 / 32F, 6 / 16F, 1F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 31 / 32F, 6 / 32F, 6 / 16F, 1F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 55 && tileSign.getSignShape() == 7)  //sipka M dolu
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 22 / 32F, 0.0F, 6 / 16F, 25 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 21 / 32F, 1 / 32F, 6 / 16F, 22 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 20 / 32F, 2 / 32F, 6 / 16F, 21 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 19 / 32F, 3 / 32F, 6 / 16F, 20 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 18 / 32F, 4 / 32F, 6 / 16F, 19 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 17 / 32F, 5 / 32F, 6 / 16F, 18 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 16 / 32F, 6 / 32F, 6 / 16F, 17 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 32F, 7 / 32F, 6 / 16F, 16 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 32F, 8 / 32F, 6 / 16F, 15 / 32F, 24 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 32F, 9 / 32F, 6 / 16F, 14 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 12 / 32F, 10 / 32F, 6 / 16F, 13 / 32F, 22 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 32F, 11 / 32F, 6 / 16F, 12 / 32F, 21 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 10 / 32F, 12 / 32F, 6 / 16F, 11 / 32F, 20 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 9 / 32F, 13 / 32F, 6 / 16F, 10 / 32F, 19 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 8 / 32F, 14 / 32F, 6 / 16F, 9 / 32F, 18 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 7 / 32F, 15 / 32F, 6 / 16F, 8 / 32F, 17 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 55 && tileSign.getSignType() < 60 && tileSign.getSignShape() == 7)  //kruh
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 16F, 6 / 16F, 1 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 1 / 16F, 3 / 16F, 6 / 16F, 2 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 2 / 16F, 6 / 16F, 3 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 3 / 16F, 1 / 16F, 6 / 16F, 5 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 5 / 16F, 0.0F, 6 / 16F, 11 / 16F, 16 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F, 13 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F, 14 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F, 15 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 60 && tileSign.getSignShape() == 7)  //pulka uprostred
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 4 / 16F, 0.0F, 6 / 16F, 12 / 16F, 1F);                                    
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 61 && tileSign.getSignShape() == 7)  //-3 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 3 / 16F, 6 / 16F, 1F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 61 && tileSign.getSignShape() == 7) //-2 uzky obdelnik
                                {
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 2 / 16F, 6 / 16F, 1F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(6 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 8:
                                if(tileSign.getSignType() > 0 && tileSign.getSignType() < 69 && tileSign.getSignShape() == 8) //kruh
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 16F, 6 / 16F, 1 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 1 / 16F, 3 / 16F, 6 / 16F, 2 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 2 / 16F, 6 / 16F, 3 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 3 / 16F, 1 / 16F, 6 / 16F, 5 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 5 / 16F, 0.0F, 6 / 16F, 11 / 16F, 16 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F, 13 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F, 14 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F, 15 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 68 && tileSign.getSignType() < 137 && tileSign.getSignShape() == 8)  //ctverec
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(6 / 16F, 0.0F, 0.0F, 6 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
                case 2:

                    renderer.setRenderBounds(7 / 16F, 0.0F, 6 / 16F, 9 / 16F, signTop / 16F, 7 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 7 / 16F, 0.46875F, signTop / 16F, 8 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(0.53125F, 0.0F, 7 / 16F, 9 / 16F, signTop / 16F, 8 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:  //ctverec
                                renderer.setRenderBounds(0.0F, 0.0F, 5 / 16F, 1F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1: //kruh
                                renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 1 / 16F, 5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 2 / 16F, 5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 3 / 16F, 5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 5 / 16F, 5 / 16F, 1F, 11 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F, 13 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 13 / 16F, 5 / 16F, 14 / 16F, 14 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 14 / 16F, 5 / 16F, 13 / 16F, 15 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 5 / 16F, 11 / 16F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:  //trojuhelnik
                                renderer.setRenderBounds(1 / 16F, 0.0F, 5 / 16F, 15 / 16F, 1 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 1 / 16F, 5 / 16F, 1F, 4 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 4 / 16F, 5 / 16F, 15 / 16F, 6 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 6 / 16F, 5 / 16F, 14 / 16F, 8 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 8 / 16F, 5 / 16F, 13 / 16F, 10 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(4 / 16F, 10 / 16F, 5 / 16F, 12 / 16F, 12 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 5 / 16F, 11 / 16F, 14 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 14 / 16F, 5 / 16F, 10 / 16F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:  //diamant
                                renderer.setRenderBounds(7 / 16F, 0.0F, 5 / 16F, 9 / 16F, 1 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 1 / 16F, 5 / 16F, 10 / 16F, 2 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 2 / 16F, 5 / 16F, 11 / 16F, 3 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(4 / 16F, 3 / 16F, 5 / 16F, 12 / 16F, 0.25F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 0.25F, 5 / 16F, 13 / 16F, 5 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 5 / 16F, 5 / 16F, 14 / 16F, 6 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 6 / 16F, 5 / 16F, 15 / 16F, 7 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 7 / 16F, 5 / 16F, 1F, 9 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 9 / 16F, 5 / 16F, 15 / 16F, 10 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 10 / 16F, 5 / 16F, 14 / 16F, 11 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 11 / 16F, 5 / 16F, 13 / 16F, 12 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(4 / 16F, 12 / 16F, 5 / 16F, 12 / 16F, 13 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 13 / 16F, 5 / 16F, 11 / 16F, 14 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 14 / 16F, 5 / 16F, 10 / 16F, 15 / 16F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(7 / 16F, 15 / 16F, 5 / 16F, 9 / 16F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 4:  //obdelnik -2
                                renderer.setRenderBounds(2 / 16F, 0.0F, 5 / 16F, 14 / 16F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 5:
                                if(tileSign.getSignType() == 1 && tileSign.getSignShape() == 5)  //STOP
                                {                        
                                    renderer.setRenderBounds(4 / 16F, 0.0F, 5 / 16F, 12 / 16F, 1 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 1 / 16F, 5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 2 / 16F, 5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 3 / 16F, 5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 4 / 16F, 5 / 16F, 1F, 12 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F, 13 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 13 / 16F, 5 / 16F, 14 / 16F, 14 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 14 / 16F, 5 / 16F, 13 / 16F, 15 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 16F, 15 / 16F, 5 / 16F, 12 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 1 && tileSign.getSignType() < 4 && tileSign.getSignShape() == 5)  //obraceny trojuhelnik
                                {                        
                                    renderer.setRenderBounds(1 / 16F, 15 / 16F, 5 / 16F, 15 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 12 / 16F, 5 / 16F, 1F, 15 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 10 / 16F, 5 / 16F, 15 / 16F, 12 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 8 / 16F, 5 / 16F, 14 / 16F, 10 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 6 / 16F, 5 / 16F, 13 / 16F, 8 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 16F, 4 / 16F, 5 / 16F, 12 / 16F, 6 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 5 / 16F, 11 / 16F, 4 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 16F, 0.0F, 5 / 16F, 10 / 16F, 2 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 3 && tileSign.getSignType() < 46 && tileSign.getSignShape() == 5)  //pulka nahore
                                {                        
                                    renderer.setRenderBounds(1 / 16F, 8 / 16F, 5 / 16F, 15 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 45 && tileSign.getSignType() < 62 && tileSign.getSignShape() == 5)  //pulka dole
                                {                        
                                    renderer.setRenderBounds(1 / 16F, 0.0F, 5 / 16F, 15 / 16F, 8 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                /*if(tileSign.getSignType() == 62 && tileSign.getSignShape() == 5)  //bocni trojuhelnik  SVT NEJDE
                                {
                                }*/
                                if(tileSign.getSignType() > 62 && tileSign.getSignType() < 76 && tileSign.getSignShape() == 5)  //-4 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(4 / 16F, 0.0F, 5 / 16F, 12 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(0.0F, 0.0F, 6 / 16F, 1F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 6:
                                /*  //pismo bez pozadi nejde*/
                                if(tileSign.getSignType() > 72 && tileSign.getSignType() < 145 && tileSign.getSignShape() == 6)  //ctverec
                                {                        
                                    renderer.setRenderBounds(0.0F, 0.0F, 5 / 16F, 1F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(0.0F, 0.0F, 6 / 16F, 1F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 7:
                                /*if(tileSign.getSignType() >= 1 && tileSign.getSignType() < 7 && tileSign.getSignShape() == 7)  //kriz 1
                                {                        
                                    renderer.setRenderBounds(2 / 32F, 6 / 32F, 5 / 16F, 7 / 32F, 7 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 6 / 32F, 5 / 16F, 30 / 32F, 7 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 7 / 32F, 5 / 16F, 9 / 32F, 8 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 7 / 32F, 5 / 16F, 30 / 32F, 8 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 8 / 32F, 5 / 16F, 10 / 32F, 9 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 8 / 32F, 5 / 16F, 30 / 32F, 9 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 9 / 32F, 5 / 16F, 12 / 32F, 10 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 9 / 32F, 5 / 16F, 30 / 32F, 10 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 10 / 32F, 5 / 16F, 13 / 32F, 11 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 10 / 32F, 5 / 16F, 29 / 32F, 11 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 11 / 32F, 5 / 16F, 15 / 32F, 12 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 11 / 32F, 5 / 16F, 28 / 32F, 12 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 12 / 32F, 5 / 16F, 26 / 32F, 13 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 13 / 32F, 5 / 16F, 25 / 32F, 14 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 14 / 32F, 5 / 16F, 23 / 32F, 15 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 15 / 32F, 5 / 16F, 22 / 32F, 17 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 17 / 32F, 5 / 16F, 23 / 32F, 18 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 18 / 32F, 5 / 16F, 25 / 32F, 19 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 19 / 32F, 5 / 16F, 26 / 32F, 20 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 20 / 32F, 5 / 16F, 15 / 32F, 21 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 20 / 32F, 5 / 16F, 28 / 32F, 21 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 21 / 32F, 5 / 16F, 13 / 32F, 22 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 21 / 32F, 5 / 16F, 29 / 32F, 22 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 22 / 32F, 5 / 16F, 12 / 32F, 23 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 22 / 32F, 5 / 16F, 30 / 32F, 23 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 23 / 32F, 5 / 16F, 10 / 32F, 24 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 23 / 32F, 5 / 16F, 30 / 32F, 24 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 24 / 32F, 5 / 16F, 9 / 32F, 25 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 24 / 32F, 5 / 16F, 30 / 32F, 25 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 25 / 32F, 5 / 16F, 7 / 32F, 26 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 25 / 32F, 5 / 16F, 30 / 32F, 26 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 6 && tileSign.getSignType() < 9 && tileSign.getSignShape() == 7)  //kriz 2
                                {                        
                                    renderer.setRenderBounds(5 / 32F, 0.0F, 5 / 16F, 6 / 32F, 1 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(26 / 32F, 0.0F, 5 / 16F, 27 / 32F, 1 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 1 / 32F, 5 / 16F, 7 / 32F, 2 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 1 / 32F, 5 / 16F, 28 / 32F, 2 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 2 / 32F, 5 / 16F, 8 / 32F, 3 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(24 / 32F, 2 / 32F, 5 / 16F, 29 / 32F, 3 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 3 / 32F, 5 / 16F, 9 / 32F, 4 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 3 / 32F, 5 / 16F, 30 / 32F, 4 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 4 / 32F, 5 / 16F, 10 / 32F, 5 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 4 / 32F, 5 / 16F, 31 / 32F, 5 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 5 / 32F, 5 / 16F, 11 / 32F, 6 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 5 / 32F, 5 / 16F, 1F, 6 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 6 / 32F, 5 / 16F, 12 / 32F, 7 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 6 / 32F, 5 / 16F, 31 / 32F, 7 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 7 / 32F, 5 / 16F, 13 / 32F, 8 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 7 / 32F, 5 / 16F, 30 / 32F, 8 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 8 / 32F, 5 / 16F, 14 / 32F, 9 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(18 / 32F, 8 / 32F, 5 / 16F, 29 / 32F, 9 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 9 / 32F, 5 / 16F, 15 / 32F, 10 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 9 / 32F, 5 / 16F, 28 / 32F, 10 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 10 / 32F, 5 / 16F, 27 / 32F, 11 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 11 / 32F, 5 / 16F, 26 / 32F, 12 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 12 / 32F, 5 / 16F, 25 / 32F, 13 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 13 / 32F, 5 / 16F, 24 / 32F, 14 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 14 / 32F, 5 / 16F, 23 / 32F, 15 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 15 / 32F, 5 / 16F, 22 / 32F, 17 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 17 / 32F, 5 / 16F, 23 / 32F, 18 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 18 / 32F, 5 / 16F, 24 / 32F, 19 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 19 / 32F, 5 / 16F, 25 / 32F, 20 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 20 / 32F, 5 / 16F, 26 / 32F, 21 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 21 / 32F, 5 / 16F, 27 / 32F, 22 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 22 / 32F, 5 / 16F, 15 / 32F, 23 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 22 / 32F, 5 / 16F, 28 / 32F, 23 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 23 / 32F, 5 / 16F, 14 / 32F, 24 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(18 / 32F, 23 / 32F, 5 / 16F, 29 / 32F, 24 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 24 / 32F, 5 / 16F, 13 / 32F, 25 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 24 / 32F, 5 / 16F, 30 / 32F, 25 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 25 / 32F, 5 / 16F, 12 / 32F, 26 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 25 / 32F, 5 / 16F, 31 / 32F, 26 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 26 / 32F, 5 / 16F, 11 / 32F, 27 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 26 / 32F, 5 / 16F, 1F, 27 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 27 / 32F, 5 / 16F, 10 / 32F, 28 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 27 / 32F, 5 / 16F, 31 / 32F, 28 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 28 / 32F, 5 / 16F, 9 / 32F, 29 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 28 / 32F, 5 / 16F, 30 / 32F, 29 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 29 / 32F, 5 / 16F, 8 / 32F, 30 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(24 / 32F, 29 / 32F, 5 / 16F, 29 / 32F, 30 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 30 / 32F, 5 / 16F, 7 / 32F, 31 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 30 / 32F, 5 / 16F, 28 / 32F, 31 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 31 / 32F, 5 / 16F, 6 / 32F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(26 / 32F, 31 / 32F, 5 / 16F, 27 / 32F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 9 && tileSign.getSignShape() == 7)  //kriz 3
                                {                        
                                    renderer.setRenderBounds(1 / 32F, 4 / 32F, 5 / 16F, 5 / 32F, 5 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(27 / 32F, 4 / 32F, 5 / 16F, 31 / 32F, 5 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 5 / 32F, 5 / 16F, 7 / 32F, 6 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 5 / 32F, 5 / 16F, 1F, 6 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 6 / 32F, 5 / 16F, 9 / 32F, 7 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 6 / 32F, 5 / 16F, 1F, 7 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 7 / 32F, 5 / 16F, 11 / 32F, 8 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 7 / 32F, 5 / 16F, 31 / 32F, 8 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 8 / 32F, 5 / 16F, 13 / 32F, 9 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 8 / 32F, 5 / 16F, 30 / 32F, 9 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 9 / 32F, 5 / 16F, 15 / 32F, 10 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 9 / 32F, 5 / 16F, 28 / 32F, 10 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 10 / 32F, 5 / 16F, 26 / 32F, 11 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 11 / 32F, 5 / 16F, 4 / 32F, 12 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 11 / 32F, 5 / 16F, 24 / 32F, 12 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(28 / 32F, 11 / 32F, 5 / 16F, 30 / 32F, 12 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 12 / 32F, 5 / 16F, 7 / 32F, 13 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(11 / 32F, 12 / 32F, 5 / 16F, 21 / 32F, 13 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 12 / 32F, 5 / 16F, 1F, 13 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 13 / 32F, 5 / 16F, 9 / 32F, 14 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(13 / 32F, 13 / 32F, 5 / 16F, 19 / 32F, 14 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 13 / 32F, 5 / 16F, 1F, 14 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 14 / 32F, 5 / 16F, 11 / 32F, 15 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(15 / 32F, 14 / 32F, 5 / 16F, 17 / 32F, 15 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 14 / 32F, 5 / 16F, 31 / 32F, 15 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 15 / 32F, 5 / 16F, 13 / 32F, 16 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 15 / 32F, 5 / 16F, 30 / 32F, 16 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 16 / 32F, 5 / 16F, 15 / 32F, 17 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 16 / 32F, 5 / 16F, 28 / 32F, 17 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 17 / 32F, 5 / 16F, 26 / 32F, 18 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 18 / 32F, 5 / 16F, 24 / 32F, 19 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 19 / 32F, 5 / 16F, 22 / 32F, 20 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 20 / 32F, 5 / 16F, 24 / 32F, 21 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 21 / 32F, 5 / 16F, 26 / 32F, 22 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 22 / 32F, 5 / 16F, 15 / 32F, 23 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 22 / 32F, 5 / 16F, 28 / 32F, 23 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 23 / 32F, 5 / 16F, 13 / 32F, 24 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 23 / 32F, 5 / 16F, 30 / 32F, 24 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 24 / 32F, 5 / 16F, 11 / 32F, 25 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 24 / 32F, 5 / 16F, 31 / 32F, 25 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 25 / 32F, 5 / 16F, 9 / 32F, 26 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(23 / 32F, 25 / 32F, 5 / 16F, 1F, 26 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 26 / 32F, 5 / 16F, 7 / 32F, 27 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(25 / 32F, 26 / 32F, 5 / 16F, 1F, 27 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 27 / 32F, 5 / 16F, 5 / 32F, 28 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(27 / 32F, 27 / 32F, 5 / 16F, 31 / 32F, 28 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }*/
                                if(tileSign.getSignType() > 9 && tileSign.getSignType() < 23 && tileSign.getSignShape() == 7)  //-4 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(4 / 16F, 0.0F, 5 / 16F, 12 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 22 && tileSign.getSignType() < 43 && tileSign.getSignShape() == 7)  //diamant
                                {                        
                                    renderer.setRenderBounds(7 / 16F, 0.0F, 5 / 16F, 9 / 16F, 1 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 16F, 1 / 16F, 5 / 16F, 10 / 16F, 2 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 2 / 16F, 5 / 16F, 11 / 16F, 3 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 16F, 3 / 16F, 5 / 16F, 12 / 16F, 0.25F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 0.25F, 5 / 16F, 13 / 16F, 5 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 5 / 16F, 5 / 16F, 14 / 16F, 6 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 6 / 16F, 5 / 16F, 15 / 16F, 7 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 7 / 16F, 5 / 16F, 1F, 9 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 9 / 16F, 5 / 16F, 15 / 16F, 10 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 10 / 16F, 5 / 16F, 14 / 16F, 11 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 11 / 16F, 5 / 16F, 13 / 16F, 12 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 16F, 12 / 16F, 5 / 16F, 12 / 16F, 13 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 13 / 16F, 5 / 16F, 11 / 16F, 14 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 16F, 14 / 16F, 5 / 16F, 10 / 16F, 15 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 16F, 15 / 16F, 5 / 16F, 9 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 42 && tileSign.getSignType() < 54 && tileSign.getSignShape() == 7)  //ctverec
                                {                        
                                    renderer.setRenderBounds(0.0F, 0.0F, 5 / 16F, 1F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 54 && tileSign.getSignShape() == 7)  //sipka dolu 
                                {                        
                                    renderer.setRenderBounds(15 / 32F, 1 / 32F, 5 / 16F, 17 / 32F, 2 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(14 / 32F, 2 / 32F, 5 / 16F, 18 / 32F, 3 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(13 / 32F, 3 / 32F, 5 / 16F, 19 / 32F, 4 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(12 / 32F, 4 / 32F, 5 / 16F, 20 / 32F, 5 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(11 / 32F, 5 / 32F, 5 / 16F, 21 / 32F, 6 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 6 / 32F, 5 / 16F, 22 / 32F, 7 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 7 / 32F, 5 / 16F, 23 / 32F, 8 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 8 / 32F, 5 / 16F, 24 / 32F, 9 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 9 / 32F, 5 / 16F, 25 / 32F, 10 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 10 / 32F, 5 / 16F, 26 / 32F, 11 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 11 / 32F, 5 / 16F, 27 / 32F, 12 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 12 / 32F, 5 / 16F, 28 / 32F, 13 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 13 / 32F, 5 / 16F, 29 / 32F, 14 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 14 / 32F, 5 / 16F, 30 / 32F, 15 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 15 / 32F, 5 / 16F, 31 / 32F, 16 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 16 / 32F, 5 / 16F, 1F, 21 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 21 / 32F, 5 / 16F, 26 / 32F, 26 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(17 / 32F, 26 / 32F, 5 / 16F, 26 / 32F, 27 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 26 / 32F, 5 / 16F, 15 / 32F, 27 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(18 / 32F, 27 / 32F, 5 / 16F, 26 / 32F, 28 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 27 / 32F, 5 / 16F, 14 / 32F, 28 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(19 / 32F, 28 / 32F, 5 / 16F, 26 / 32F, 29 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 28 / 32F, 5 / 16F, 13 / 32F, 29 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(20 / 32F, 29 / 32F, 5 / 16F, 26 / 32F, 30 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 29 / 32F, 5 / 16F, 12 / 32F, 30 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(21 / 32F, 30 / 32F, 5 / 16F, 26 / 32F, 31 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 30 / 32F, 5 / 16F, 11 / 32F, 31 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(22 / 32F, 31 / 32F, 5 / 16F, 26 / 32F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 31 / 32F, 5 / 16F, 10 / 32F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 55 && tileSign.getSignShape() == 7)  //sipka M dolu 
                                {                        
                                    renderer.setRenderBounds(0.0F, 22 / 32F, 5 / 16F, 1F, 25 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 32F, 21 / 32F, 5 / 16F, 31 / 32F, 22 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 32F, 20 / 32F, 5 / 16F, 30 / 32F, 21 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 32F, 19 / 32F, 5 / 16F, 29 / 32F, 20 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(4 / 32F, 18 / 32F, 5 / 16F, 28 / 32F, 19 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 32F, 17 / 32F, 5 / 16F, 27 / 32F, 18 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(6 / 32F, 16 / 32F, 5 / 16F, 26 / 32F, 17 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(7 / 32F, 15 / 32F, 5 / 16F, 25 / 32F, 16 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(8 / 32F, 14 / 32F, 5 / 16F, 24 / 32F, 15 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(9 / 32F, 13 / 32F, 5 / 16F, 23 / 32F, 14 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 32F, 12 / 32F, 5 / 16F, 22 / 32F, 13 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(11 / 32F, 11 / 32F, 5 / 16F, 21 / 32F, 12 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(12 / 32F, 10 / 32F, 5 / 16F, 20 / 32F, 11 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(13 / 32F, 9 / 32F, 5 / 16F, 19 / 32F, 10 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(14 / 32F, 8 / 32F, 5 / 16F, 18 / 32F, 9 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(15 / 32F, 7 / 32F, 5 / 16F, 17 / 32F, 8 / 32F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 55 && tileSign.getSignType() < 60 && tileSign.getSignShape() == 7)  //kruh
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 1 / 16F, 5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 2 / 16F, 5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 3 / 16F, 5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 5 / 16F, 5 / 16F, 1F, 11 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F, 13 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 13 / 16F, 5 / 16F, 14 / 16F, 14 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 14 / 16F, 5 / 16F, 13 / 16F, 15 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 5 / 16F, 11 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 60 && tileSign.getSignShape() == 7)  //pulka uprostred
                                {                        
                                    renderer.setRenderBounds(0.0F, 4 / 16F, 5 / 16F, 1F, 12 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 61 && tileSign.getSignShape() == 7)  //-3 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(3 / 16F, 0.0F, 5 / 16F, 13 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 61 && tileSign.getSignShape() == 7) //-2 uzky obdelnik
                                {
                                    renderer.setRenderBounds(2 / 16F, 0.0F, 5 / 16F, 14 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(0.0F, 0.0F, 6 / 16F, 1F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 8:
                                if(tileSign.getSignType() > 0 && tileSign.getSignType() < 69 && tileSign.getSignShape() == 8) //kruh
                                {                        
                                    renderer.setRenderBounds(5 / 16F, 0.0F, 5 / 16F, 11 / 16F, 1 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 1 / 16F, 5 / 16F, 13 / 16F, 2 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 2 / 16F, 5 / 16F, 14 / 16F, 3 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 3 / 16F, 5 / 16F, 15 / 16F, 5 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(0.0F, 5 / 16F, 5 / 16F, 1F, 11 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F, 13 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(2 / 16F, 13 / 16F, 5 / 16F, 14 / 16F, 14 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(3 / 16F, 14 / 16F, 5 / 16F, 13 / 16F, 15 / 16F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(5 / 16F, 15 / 16F, 5 / 16F, 11 / 16F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 68 && tileSign.getSignType() < 137 && tileSign.getSignShape() == 8)  //ctverec
                                {                        
                                    renderer.setRenderBounds(0.0F, 0.0F, 5 / 16F, 1F, 1F, 6 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(0.0F, 0.0F, 6 / 16F, 1F, 1F, 6 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
                case 3:
                    renderer.setRenderBounds(9 / 16F, 0.0F, 7 / 16F, 10 / 16F, signTop / 16F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(8 / 16F, 0.0F, 7 / 16F, 9 / 16F, signTop / 16F, 7.5 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(8 / 16F, 0.0F, 8.5 / 16F, 9 / 16F, signTop / 16F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:  //ctverec
                                renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 11 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1: //kruh
                                renderer.setRenderBounds(10 / 16F, 0.0F, 5 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 1 / 16F, 3 / 16F, 11 / 16F, 2 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 2 / 16F, 2 / 16F, 11 / 16F, 3 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 3 / 16F, 1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 5 / 16F, 0.0F, 11 / 16F, 11 / 16F, 16 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F, 13 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F, 14 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F, 15 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:  //trojuhelnik
                                renderer.setRenderBounds(10 / 16F, 0.0F, 1 / 16F, 11 / 16F, 1 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 1 / 16F, 0.0F, 11 / 16F, 4 / 16F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 4 / 16F, 1 / 16F, 11 / 16F, 6 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 6 / 16F, 2 / 16F, 11 / 16F, 8 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 8 / 16F, 3 / 16F, 11 / 16F, 10 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 10 / 16F, 4 / 16F, 11 / 16F, 12 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 12 / 16F, 5 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 14 / 16F, 6 / 16F, 11 / 16F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:  //diamant
                                renderer.setRenderBounds(10 / 16F, 0.0F, 7 / 16F, 11 / 16F, 1 / 16F, 9 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 1 / 16F, 6 / 16F, 11 / 16F, 2 / 16F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 2 / 16F, 5 / 16F, 11 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 3 / 16F, 4 / 16F, 11 / 16F, 4 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 4 / 16F, 3 / 16F, 11 / 16F, 5 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 5 / 16F, 2 / 16F, 11 / 16F, 6 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 6 / 16F, 1 / 16F, 11 / 16F, 7 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 7 / 16F, 0.0F, 11 / 16F, 9 / 16F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 9 / 16F, 1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 10 / 16F, 2 / 16F, 11 / 16F, 11 / 16F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 11 / 16F, 3 / 16F, 11 / 16F, 12 / 16F, 13 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 12 / 16F, 4 / 16F, 11 / 16F, 13 / 16F, 12 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 13 / 16F, 5 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 14 / 16F, 6 / 16F, 11 / 16F, 15 / 16F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(10 / 16F, 15 / 16F, 7 / 16F, 11 / 16F, 1F, 9 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 4:  //obdelnik -2
                                renderer.setRenderBounds(10 / 16F, 0.0F, 2 / 16F, 11 / 16F, 1F, 14 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 5:
                                if(tileSign.getSignType() == 1 && tileSign.getSignShape() == 5)  //STOP
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 4 / 16F, 11 / 16F, 1 / 16F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 1 / 16F, 3 / 16F, 11 / 16F, 2 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 2 / 16F, 2 / 16F, 11 / 16F, 3 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 3 / 16F, 1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 4 / 16F, 0.0F, 11 / 16F, 12 / 16F, 16 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F, 13 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F, 14 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F, 15 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 15 / 16F, 4 / 16F, 11 / 16F, 1F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 1 && tileSign.getSignType() < 4 && tileSign.getSignShape() == 5)  //obraceny trojuhelnik
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 15 / 16F, 1 / 16F, 11 / 16F, 1F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 12 / 16F, 0.0F, 11 / 16F, 15 / 16F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 10 / 16F, 1 / 16F, 11 / 16F, 12 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 8 / 16F, 2 / 16F, 11 / 16F, 10 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 6 / 16F, 3 / 16F, 11 / 16F, 8 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 4 / 16F, 4 / 16F, 11 / 16F, 6 / 16F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 2 / 16F, 5 / 16F, 11 / 16F, 4 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 6 / 16F, 11 / 16F, 2 / 16F, 10 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 3 && tileSign.getSignType() < 46 && tileSign.getSignShape() == 5)  //pulka nahore
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 8 / 16F, 1 / 16F, 11 / 16F, 1F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 45 && tileSign.getSignType() < 62 && tileSign.getSignShape() == 5)  //pulka dole
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 1 / 16F, 11 / 16F, 8 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }/*
                                if(tileSign.getSignType() == 62 && tileSign.getSignShape() == 5)  //bocni trojuhelnik
                                {nejde}*/
                                if(tileSign.getSignType() > 62 && tileSign.getSignType() < 76 && tileSign.getSignShape() == 5)  //-4 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 4 / 16F, 11 / 16F, 1F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 10 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 6:
                                /*  //pismo bez pozadi nejde*/
                                if(tileSign.getSignType() > 72 && tileSign.getSignType() < 145 && tileSign.getSignShape() == 6)  //ctverec
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 11 / 16F, 1F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 10 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 7:
                                /*if(tileSign.getSignType() >= 1 && tileSign.getSignType() < 7 && tileSign.getSignShape() == 7)  //kriz 1
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 6 / 32F, 2 / 32F, 11 / 16F, 7 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 6 / 32F, 25 / 32F, 11 / 16F, 7 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 7 / 32F, 2 / 32F, 11 / 16F, 8 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 7 / 32F, 23 / 32F, 11 / 16F, 8 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 8 / 32F, 2 / 32F, 11 / 16F, 9 / 32F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 8 / 32F, 22 / 32F, 11 / 16F, 9 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 9 / 32F, 2 / 32F, 11 / 16F, 10 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 9 / 32F, 20 / 32F, 11 / 16F, 10 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 10 / 32F, 3 / 32F, 11 / 16F, 11 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 10 / 32F, 19 / 32F, 11 / 16F, 11 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 32F, 4 / 32F, 11 / 16F, 12 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 32F, 17 / 32F, 11 / 16F, 12 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 12 / 32F, 6 / 32F, 11 / 16F, 13 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 13 / 32F, 7 / 32F, 11 / 16F, 14 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 14 / 32F, 9 / 32F, 11 / 16F, 15 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 15 / 32F, 10 / 32F, 11 / 16F, 17 / 32F, 22 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 17 / 32F, 9 / 32F, 11 / 16F, 18 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 18 / 32F, 7 / 32F, 11 / 16F, 19 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 19 / 32F, 6 / 32F, 11 / 16F, 20 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 20 / 32F, 4 / 32F, 11 / 16F, 21 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 20 / 32F, 17 / 32F, 11 / 16F, 21 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 21 / 32F, 3 / 32F, 11 / 16F, 22 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 21 / 32F, 19 / 32F, 11 / 16F, 22 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 22 / 32F, 2 / 32F, 11 / 16F, 23 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 22 / 32F, 20 / 32F, 11 / 16F, 23 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 23 / 32F, 2 / 32F, 11 / 16F, 24 / 32F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 23 / 32F, 22 / 32F, 11 / 16F, 24 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 24 / 32F, 2 / 32F, 11 / 16F, 25 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 24 / 32F, 23 / 32F, 11 / 16F, 25 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 25 / 32F, 2 / 32F, 11 / 16F, 26 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 25 / 32F, 25 / 32F, 11 / 16F, 26 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 6 && tileSign.getSignType() < 9 && tileSign.getSignShape() == 7)  //kriz 2
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 5 / 32F, 11 / 16F, 1 / 32F, 6 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 26 / 32F, 11 / 16F, 1 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 1 / 32F, 4 / 32F, 11 / 16F, 2 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 1 / 32F, 25 / 32F, 11 / 16F, 2 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 2 / 32F, 3 / 32F, 11 / 16F, 3 / 32F, 8 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 2 / 32F, 24 / 32F, 11 / 16F, 3 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 3 / 32F, 2 / 32F, 11 / 16F, 4 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 3 / 32F, 23 / 32F, 11 / 16F, 4 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 4 / 32F, 1 / 32F, 11 / 16F, 5 / 32F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 4 / 32F, 22 / 32F, 11 / 16F, 5 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 5 / 32F, 0.0F, 11 / 16F, 6 / 32F, 11 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 5 / 32F, 21 / 32F, 11 / 16F, 6 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 6 / 32F, 1 / 32F, 11 / 16F, 7 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 6 / 32F, 20 / 32F, 11 / 16F, 7 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 7 / 32F, 2 / 32F, 11 / 16F, 8 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 7 / 32F, 19 / 32F, 11 / 16F, 8 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 8 / 32F, 3 / 32F, 11 / 16F, 9 / 32F, 14 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 8 / 32F, 18 / 32F, 11 / 16F, 9 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 9 / 32F, 4 / 32F, 11 / 16F, 10 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 9 / 32F, 17 / 32F, 11 / 16F, 10 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 10 / 32F, 5 / 32F, 11 / 16F, 11 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 32F, 6 / 32F, 11 / 16F, 12 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 12 / 32F, 7 / 32F, 11 / 16F, 13 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 13 / 32F, 8 / 32F, 11 / 16F, 14 / 32F, 24 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 14 / 32F, 9 / 32F, 11 / 16F, 15 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 15 / 32F, 10 / 32F, 11 / 16F, 17 / 32F, 22 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 17 / 32F, 9 / 32F, 11 / 16F, 18 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 18 / 32F, 8 / 32F, 11 / 16F, 19 / 32F, 24 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 19 / 32F, 7 / 32F, 11 / 16F, 20 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 20 / 32F, 6 / 32F, 11 / 16F, 21 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 21 / 32F, 5 / 32F, 11 / 16F, 22 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 22 / 32F, 4 / 32F, 11 / 16F, 23 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 22 / 32F, 17 / 32F, 11 / 16F, 23 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 23 / 32F, 3 / 32F, 11 / 16F, 24 / 32F, 14 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 23 / 32F, 18 / 32F, 11 / 16F, 24 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 24 / 32F, 2 / 32F, 11 / 16F, 25 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 24 / 32F, 19 / 32F, 11 / 16F, 25 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 25 / 32F, 1 / 32F, 11 / 16F, 26 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 25 / 32F, 20 / 32F, 11 / 16F, 26 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 26 / 32F, 0.0F, 11 / 16F, 27 / 32F, 11 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 26 / 32F, 21 / 32F, 11 / 16F, 27 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 27 / 32F, 1 / 32F, 11 / 16F, 28 / 32F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 27 / 32F, 22 / 32F, 11 / 16F, 28 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 28 / 32F, 2 / 32F, 11 / 16F, 29 / 32F, 9 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 28 / 32F, 23 / 32F, 11 / 16F, 29 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 29 / 32F, 3 / 32F, 11 / 16F, 30 / 32F, 8 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 29 / 32F, 24 / 32F, 11 / 16F, 30 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 30 / 32F, 4 / 32F, 11 / 16F, 31 / 32F, 7 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 30 / 32F, 25 / 32F, 11 / 16F, 31 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 31 / 32F, 5 / 32F, 11 / 16F, 1F, 6 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 31 / 32F, 26 / 32F, 11 / 16F, 1F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 9 && tileSign.getSignShape() == 7)  //kriz 3
                                {                        
                                }*/
                                if(tileSign.getSignType() > 9 && tileSign.getSignType() < 23 && tileSign.getSignShape() == 7)  //-4 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 4 / 16F, 11 / 16F, 1F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 22 && tileSign.getSignType() < 43 && tileSign.getSignShape() == 7)  //diamant
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 7 / 16F, 11 / 16F, 1 / 16F, 9 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 1 / 16F, 6 / 16F, 11 / 16F, 2 / 16F, 10 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 2 / 16F, 5 / 16F, 11 / 16F, 3 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 3 / 16F, 4 / 16F, 11 / 16F, 4 / 16F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 4 / 16F, 3 / 16F, 11 / 16F, 5 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 5 / 16F, 2 / 16F, 11 / 16F, 6 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 6 / 16F, 1 / 16F, 11 / 16F, 7 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 7 / 16F, 0.0F, 11 / 16F, 9 / 16F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 9 / 16F, 1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 10 / 16F, 2 / 16F, 11 / 16F, 11 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 16F, 3 / 16F, 11 / 16F, 12 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 12 / 16F, 4 / 16F, 11 / 16F, 13 / 16F, 12 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 13 / 16F, 5 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 14 / 16F, 6 / 16F, 11 / 16F, 15 / 16F, 10 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 15 / 16F, 7 / 16F, 11 / 16F, 1F, 9 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 42 && tileSign.getSignType() < 54 && tileSign.getSignShape() == 7)  //ctverec
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 11 / 16F, 1F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 54 && tileSign.getSignShape() == 7)  //sipka dolu 
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 1 / 32F, 15 / 32F, 11 / 16F, 2 / 32F, 17 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 2 / 32F, 14 / 32F, 11 / 16F, 3 / 32F, 18 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 3 / 32F, 13 / 32F, 11 / 16F, 4 / 32F, 19 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 4 / 32F, 12 / 32F, 11 / 16F, 5 / 32F, 20 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 5 / 32F, 11 / 32F, 11 / 16F, 6 / 32F, 21 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 6 / 32F, 10 / 32F, 11 / 16F, 7 / 32F, 22 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 7 / 32F, 9 / 32F, 11 / 16F, 8 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 8 / 32F, 8 / 32F, 11 / 16F, 9 / 32F, 24 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 9 / 32F, 7 / 32F, 11 / 16F, 10 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 10 / 32F, 6 / 32F, 11 / 16F, 11 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 32F, 5 / 32F, 11 / 16F, 12 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 12 / 32F, 4 / 32F, 11 / 16F, 13 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 13 / 32F, 3 / 32F, 11 / 16F, 14 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 14 / 32F, 2 / 32F, 11 / 16F, 15 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 15 / 32F, 1 / 32F, 11 / 16F, 16 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 16 / 32F, 0.0F, 11 / 16F, 21 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 21 / 32F, 6 / 32F, 11 / 16F, 26 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 26 / 32F, 17 / 32F, 11 / 16F, 27 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 26 / 32F, 6 / 32F, 11 / 16F, 27 / 32F, 15 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 27 / 32F, 18 / 32F, 11 / 16F, 28 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 27 / 32F, 6 / 32F, 11 / 16F, 28 / 32F, 14 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 28 / 32F, 19 / 32F, 11 / 16F, 29 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 28 / 32F, 6 / 32F, 11 / 16F, 29 / 32F, 13 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 29 / 32F, 20 / 32F, 11 / 16F, 30 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 29 / 32F, 6 / 32F, 11 / 16F, 30 / 32F, 12 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 30 / 32F, 21 / 32F, 11 / 16F, 31 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 30 / 32F, 6 / 32F, 11 / 16F, 31 / 32F, 11 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 31 / 32F, 22 / 32F, 11 / 16F, 1F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 31 / 32F, 6 / 32F, 11 / 16F, 1F, 10 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 55 && tileSign.getSignShape() == 7)  //sipka M dolu 
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 22 / 32F, 0.0F, 11 / 16F, 25 / 32F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 21 / 32F, 1 / 32F, 11 / 16F, 22 / 32F, 31 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 20 / 32F, 2 / 32F, 11 / 16F, 21 / 32F, 30 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 19 / 32F, 3 / 32F, 11 / 16F, 20 / 32F, 29 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 18 / 32F, 4 / 32F, 11 / 16F, 19 / 32F, 28 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 17 / 32F, 5 / 32F, 11 / 16F, 18 / 32F, 27 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 16 / 32F, 6 / 32F, 11 / 16F, 17 / 32F, 26 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 15 / 32F, 7 / 32F, 11 / 16F, 16 / 32F, 25 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 14 / 32F, 8 / 32F, 11 / 16F, 15 / 32F, 24 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 13 / 32F, 9 / 32F, 11 / 16F, 14 / 32F, 23 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 12 / 32F, 10 / 32F, 11 / 16F, 13 / 32F, 22 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 32F, 11 / 32F, 11 / 16F, 12 / 32F, 21 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 10 / 32F, 12 / 32F, 11 / 16F, 11 / 32F, 20 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 9 / 32F, 13 / 32F, 11 / 16F, 10 / 32F, 19 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 8 / 32F, 14 / 32F, 11 / 16F, 9 / 32F, 18 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 7 / 32F, 15 / 32F, 11 / 16F, 8 / 32F, 17 / 32F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 55 && tileSign.getSignType() < 60 && tileSign.getSignShape() == 7)  //kruh
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 5 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 1 / 16F, 3 / 16F, 11 / 16F, 2 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 2 / 16F, 2 / 16F, 11 / 16F, 3 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 3 / 16F, 1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 5 / 16F, 0.0F, 11 / 16F, 11 / 16F, 16 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F, 13 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F, 14 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F, 15 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 60 && tileSign.getSignShape() == 7)  //pulka uprostred
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 4 / 16F, 0.0F, 11 / 16F, 12 / 16F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() == 61 && tileSign.getSignShape() == 7)  //-3 uzky obdelnik
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 3 / 16F, 11 / 16F, 1F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 61 && tileSign.getSignShape() == 7) //-2 uzky obdelnik
                                {
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 2 / 16F, 11 / 16F, 1F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 10 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 8:
                                if(tileSign.getSignType() > 0 && tileSign.getSignType() < 69 && tileSign.getSignShape() == 8) //kruh
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 5 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 1 / 16F, 3 / 16F, 11 / 16F, 2 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 2 / 16F, 2 / 16F, 11 / 16F, 3 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 3 / 16F, 1 / 16F, 11 / 16F, 5 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 5 / 16F, 0.0F, 11 / 16F, 11 / 16F, 16 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F, 13 / 16F, 15 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F, 14 / 16F, 14 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F, 15 / 16F, 13 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    renderer.setRenderBounds(10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F, 1F, 11 / 16F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                if(tileSign.getSignType() > 68 && tileSign.getSignType() < 137 && tileSign.getSignShape() == 8)  //ctverec
                                {                        
                                    renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 11 / 16F, 1F, 1F);
                                    renderer.renderStandardBlock(block, x, y, z);
                                    break;
                                }
                                renderer.setRenderBounds(10 / 16F, 0.0F, 0.0F, 10 / 16F, 1F, 1F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
                default:

                    renderer.setRenderBounds(7 / 16F, 0.0F, 9 / 16F, 9 / 16F, 1F, 10 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(7 / 16F, 0.0F, 0.5F, 0.46875F, 1F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);
                    renderer.setRenderBounds(0.53125F, 0.0F, 0.5F, 9 / 16F, 1F, 9 / 16F);
                    renderer.renderStandardBlock(block, x, y, z);

                    if(world.getBlockMetadata(x, y, z) != 0)
                    {
                        switch(tileSign.getSignShape())
                        {
                            case 0:
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 1:
                                renderer.setRenderBounds(5 / 16F, 0.0F, 10 / 16F, 11 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 1 / 16F, 10 / 16F, 13 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 2 / 16F, 10 / 16F, 14 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 3 / 16F, 10 / 16F, 15 / 16F, 5 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 5 / 16F, 10 / 16F, 1F, 11 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 11 / 16F, 10 / 16F, 15 / 16F, 13 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 13 / 16F, 10 / 16F, 14 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 14 / 16F, 10 / 16F, 13 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 15 / 16F, 10 / 16F, 11 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 2:
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 0.25F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 0.25F, 10 / 16F, 15 / 16F, 6 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 6 / 16F, 10 / 16F, 0.8875F, 0.5F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 0.5F, 10 / 16F, 0.8225F, 10 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 10 / 16F, 10 / 16F, 12 / 16F, 12 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 12 / 16F, 10 / 16F, 11 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 14 / 16F, 10 / 16F, 10 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 3:
                                renderer.setRenderBounds(6 / 16F, 0.0F, 10 / 16F, 10 / 16F, 1 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 1 / 16F, 10 / 16F, 11 / 16F, 2 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 2 / 16F, 10 / 16F, 12 / 16F, 3 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 3 / 16F, 10 / 16F, 13 / 16F, 0.25F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 0.25F, 10 / 16F, 14 / 16F, 5 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 5 / 16F, 10 / 16F, 15 / 16F, 6 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.0F, 6 / 16F, 10 / 16F, 1F, 10 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(1 / 16F, 10 / 16F, 10 / 16F, 15 / 16F, 11 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(2 / 16F, 11 / 16F, 10 / 16F, 14 / 16F, 12 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(3 / 16F, 12 / 16F, 10 / 16F, 13 / 16F, 13 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(0.25F, 13 / 16F, 10 / 16F, 12 / 16F, 14 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(5 / 16F, 14 / 16F, 10 / 16F, 11 / 16F, 15 / 16F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                renderer.setRenderBounds(6 / 16F, 15 / 16F, 10 / 16F, 10 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 4:
                                renderer.setRenderBounds(3 / 16F, 0.0F, 10 / 16F, 12 / 16F, 1F, 11 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 5: //s,v,t
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 6:
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 7:
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                            case 8:
                                renderer.setRenderBounds(0.0F, 0.0F, 10 / 16F, 1F, 1F, 10 / 16F);
                                renderer.renderStandardBlock(block, x, y, z);
                                break;
                        }
                    }
                    break;
            }
            GL11.glPopMatrix();
        }
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return ClientProxy.renderSignPostId;
    }

    private void renderInInventory(Tessellator tessellator, RenderBlocks renderer, Block block, int metadata)
    {
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(8, metadata));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

}
