/*
Road Stuff - A Minecraft MODification by KillerMapper - 2015
The MIT License (MIT)
Copyright (c) 2015 KillerMapper
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

package net.killermapper.roadstuff.common.blocks.asphalt;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAsphaltLine6 extends Block
{

    public static String[] subBlock = new String[] {"experiment15", "experiment16", "experiment17", "experiment19", "experiment20", "experiment21", "experiment24", "experiment25"};
    private IIcon asphaltBase, Experiment0, Experiment15, Experiment16, Experiment17, Experiment19, Experiment20, Experiment21, Experiment24, Experiment25;

    public BlockAsphaltLine6()
    {
        super(Material.rock);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return ClientProxy.renderAsphaltLinesId;
    }

    public int damageDropped(int metadata)
    {
        if(metadata == 8)
            return 0;
        if(metadata == 9)
            return 1;
        if(metadata == 10)
            return 2;
        if(metadata == 11)
            return 3;
        if(metadata == 12)
            return 4;
        if(metadata == 13)
            return 5;
        if(metadata == 14)
            return 6;
        if(metadata == 15)
            return 7;
        return metadata;
    }

    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        for(int i = 0; i < subBlock.length; i++)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.Experiment0 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP0");
        this.asphaltBase = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltBase");
        this.Experiment15 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP15");
        this.Experiment16 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP16");
        this.Experiment17 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP17");
        this.Experiment19 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP19");
        this.Experiment20 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP20");
        this.Experiment21 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP21");
        this.Experiment24 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP24");
        this.Experiment25 = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltEXP25");
    }

    public IIcon getIcon(int side, int metadata)
    {
        if(side == 1)
        {
            if(metadata == 0 || metadata == 8)
            {
                return this.Experiment15;
            }
            if(metadata == 1 || metadata == 9)
            {
                return this.Experiment16;
            }
            if(metadata == 2 || metadata == 10)
            {
                return this.Experiment17;
            }
            if(metadata == 3 || metadata == 11)
            {
                return this.Experiment19;
            }
            if(metadata == 4 || metadata == 12)
            {
                return this.Experiment20;
            }
            if(metadata == 5 || metadata == 13)
            {
                return this.Experiment21;
            }
            if(metadata == 6 || metadata == 14)
            {
                return this.Experiment24;
            }
            if(metadata == 7 || metadata == 15)
            {
                return this.Experiment25;
            }
        }
        if(side == 2 || side == 3)
        {
            if(metadata == 2)
            {
                return this.Experiment0;
            }
        }
        if(side == 4 || side == 5)
        {
            if(metadata == 10)
            {
                return this.Experiment0;
            }
        }
        return this.asphaltBase;
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int meta = 0;
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        if(stack.getItemDamage() == 0)
        {
            if(direction == 0 || direction == 2)
                meta = 0;
            if(direction == 1 || direction == 3)
                meta = 8;
        }
        if(stack.getItemDamage() == 1)
        {
            if(direction == 0 || direction == 2)
                meta = 1;
            if(direction == 1 || direction == 3)
                meta = 9;
        }
        if(stack.getItemDamage() == 2)
        {
            if(direction == 0 || direction == 2)
                meta = 2;
            if(direction == 1 || direction == 3)
                meta = 10;
        }
        if(stack.getItemDamage() == 3)
        {
            if(direction == 0 || direction == 2)
                meta = 3;
            if(direction == 1 || direction == 3)
                meta = 11;
        }
        if(stack.getItemDamage() == 4)
        {
            if(direction == 0 || direction == 2)
                meta = 4;
            if(direction == 1 || direction == 3)
                meta = 12;
        }
        if(stack.getItemDamage() == 5)
        {
            if(direction == 0 || direction == 2)
                meta = 5;
            if(direction == 1 || direction == 3)
                meta = 13;
        }
        if(stack.getItemDamage() == 6)
        {
            if(direction == 0 || direction == 2)
                meta = 6;
            if(direction == 1 || direction == 3)
                meta = 14;
        }
        if(stack.getItemDamage() == 7)
        {
            if(direction == 0 || direction == 2)
                meta = 7;
            if(direction == 1 || direction == 3)
                meta = 15;
        }
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
}