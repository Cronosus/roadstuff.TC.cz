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

public class BlockAsphaltLine2 extends Block
{

    public static String[] subBlock = new String[] {"simplewhitelineC", "simpleyellowlineC", "largewhitelineC", "largeyellowlineC", "doublewhitelineC", "doubleyellowlineC"};
    private IIcon asphaltBase, simpleWhiteLineC, simpleYellowLineC, largeWhiteLineC, largeYellowLineC, doubleWhiteLineC, doubleYellowLineC, simpleWhiteLine, simpleYellowLine, largeWhiteLine, largeYellowLine, doubleWhiteLine, doubleYellowLine;

    public BlockAsphaltLine2()
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
        this.asphaltBase = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltBase");
        this.simpleWhiteLineC = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltSWLC");
        this.simpleYellowLineC = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltSYLC");
        this.largeWhiteLineC = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltLWLC");
        this.largeYellowLineC = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltLYLC");
        this.doubleWhiteLineC = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltDWLC");
        this.doubleYellowLineC = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltDYLC");
        this.simpleWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltSWL");
        this.simpleYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltSYL");
        this.largeWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltLWL");
        this.largeYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltLYL");
        this.doubleWhiteLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltDWL");
        this.doubleYellowLine = iconRegister.registerIcon(RoadStuff.MODID + ":asphalt/asphaltDYL");
    }

    public IIcon getIcon(int side, int metadata)
    {
        if(side == 1)
        {
            if(metadata == 0 || metadata == 8)
            {
                return this.simpleWhiteLineC;
            }
            if(metadata == 1 || metadata == 9)
            {
                return this.simpleYellowLineC;
            }
            if(metadata == 2 || metadata == 10)
            {
                return this.largeWhiteLineC;
            }
            if(metadata == 3 || metadata == 11)
            {
                return this.largeYellowLineC;
            }
            if(metadata == 4 || metadata == 12)
            {
                return this.doubleWhiteLineC;
            }
            if(metadata == 5 || metadata == 13)
            {
                return this.doubleYellowLineC;
            }
        }
        if(side == 4 || side == 5)
        {
            if(metadata == 0)
            {
                return this.simpleWhiteLine;
            }
            if(metadata == 1)
            {
                return this.simpleYellowLine;
            }
            if(metadata == 2)
            {
                return this.largeWhiteLine;
            }
            if(metadata == 3)
            {
                return this.largeYellowLine;
            }
            if(metadata == 4)
            {
                return this.doubleWhiteLine;
            }
            if(metadata == 5)
            {
                return this.doubleYellowLine;
            }
        }
        if(side == 2 || side == 3)
        {
            if(metadata == 8)
            {
                return this.simpleWhiteLine;
            }
            if(metadata == 9)
            {
                return this.simpleYellowLine;
            }
            if(metadata == 10)
            {
                return this.largeWhiteLine;
            }
            if(metadata == 11)
            {
                return this.largeYellowLine;
            }
            if(metadata == 12)
            {
                return this.doubleWhiteLine;
            }
            if(metadata == 13)
            {
                return this.doubleYellowLine;
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
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
}
