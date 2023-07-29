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

package net.killermapper.roadstuff.common.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.killermapper.roadstuff.common.Reference;
import net.killermapper.roadstuff.common.RoadStuff;
import net.killermapper.roadstuff.common.init.RoadStuffAchievements;
import net.killermapper.roadstuff.common.init.RoadStuffConfig;
import net.killermapper.roadstuff.common.tiles.TileEntityBlockTrafficSign;
import net.killermapper.roadstuff.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTrafficSign extends Block
{
    public static String[] subBlock = new String[] {"signpost", "sign"};

    // Sign textures: square - circle - triangle - diamond - rectangle - misc.

    private IIcon signDiamond[] = new IIcon[Reference.maxSignDiamond];
    private IIcon signSquare[] = new IIcon[Reference.maxSignSquare];
    private IIcon signCircle[] = new IIcon[Reference.maxSignCircle];
    private IIcon signTriangle[] = new IIcon[Reference.maxSignTriangle];
    private IIcon signRectangle[] = new IIcon[Reference.maxSignRectangle];
    private IIcon signMisc[] = new IIcon[Reference.maxSignMisc];
    private IIcon signMiscB[] = new IIcon[Reference.maxSignMiscB];
    private IIcon signLetter[] = new IIcon[Reference.maxSignLetter];
    private IIcon signLetterB[] = new IIcon[Reference.maxSignLetterB];
    private IIcon signTrain[] = new IIcon[Reference.maxSignTrain];
    private IIcon signTrainB[] = new IIcon[Reference.maxSignTrainB];
    private IIcon signSpeed[] = new IIcon[Reference.maxSignSpeed];
    private IIcon signSpeedB[] = new IIcon[Reference.maxSignSpeedB];
    private IIcon signPost, signBase, signError, Misc62a, Misc5Ba;

    public BlockTrafficSign()
    {
        super(Material.iron);
        this.setCreativeTab(RoadStuff.RoadStuffCreativeTabs);
    }

    public int damageDropped(int metadata)
    {
        return metadata;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderType()
    {
        return ClientProxy.renderSignPostId;
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
        for(int i = 0; i < Reference.maxSignDiamond; i++)
        {
            this.signDiamond[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/diamond/diamond" + i);
        }
        for(int i = 0; i < Reference.maxSignSquare; i++)
        {
            this.signSquare[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/square/square" + i);
        }
        for(int i = 0; i < Reference.maxSignCircle; i++)
        {
            this.signCircle[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/circle/circle" + i);
        }
        for(int i = 0; i < Reference.maxSignTriangle; i++)
        {
            this.signTriangle[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/triangle/triangle" + i);
        }
        for(int i = 0; i < Reference.maxSignRectangle; i++)
        {
            this.signRectangle[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/rectangle/rectangle" + i);
        }
        for(int i = 0; i < Reference.maxSignMisc; i++)
        {
            this.signMisc[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/misc/misc" + i);
        }
        for(int i = 0; i < Reference.maxSignMiscB; i++)
        {
            this.signMiscB[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/misc/misc" + i + "B");
        }
        for(int i = 0; i < Reference.maxSignLetter; i++)
        {
            this.signLetter[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/letter/letter" + i);
        }
        for(int i = 0; i < Reference.maxSignLetterB; i++)
        {
            this.signLetterB[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/letter/letter" + i + "B");
        }
        for(int i = 0; i < Reference.maxSignTrain; i++)
        {
            this.signTrain[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/train/train" + i);
        }
        for(int i = 0; i < Reference.maxSignTrainB; i++)
        {
            this.signTrainB[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/train/train" + i + "B");
        }
        for(int i = 0; i < Reference.maxSignSpeed; i++)
        {
            this.signSpeed[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/speed/speed" + i);
        }
        for(int i = 0; i < Reference.maxSignSpeedB; i++)
        {
            this.signSpeedB[i] = iconRegister.registerIcon(RoadStuff.MODID + ":sign/speed/speed" + i + "B");
        }

        this.signPost = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signPost");
        this.signBase = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signBase");
        this.signError = iconRegister.registerIcon(RoadStuff.MODID + ":sign/signError");
        this.Misc62a = iconRegister.registerIcon(RoadStuff.MODID + ":sign/misc/misc62a");
        this.Misc5Ba = iconRegister.registerIcon(RoadStuff.MODID + ":sign/misc/misc5Ba");
    }

    public IIcon getIcon(int side, int metadata)
    {
        if(side == 3)
        {
            if(metadata != 0)
                return this.signBase;
        }
        return this.signPost;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        if(world.getBlockMetadata(x, y, z) == 1)
        {
            TileEntity tile = world.getTileEntity(x, y, z);
            if(tile instanceof TileEntityBlockTrafficSign)
            {
                TileEntityBlockTrafficSign tileEntity = (TileEntityBlockTrafficSign)tile;
                short signFace = 0;
                short signBack = 0;
                switch(((TileEntityBlockTrafficSign)tile).getSignDirection())
                {
                    case 0:
                        signFace = 3;
                        signBack = 2;
                        break;
                    case 1:
                        signFace = 4;
                        signBack = 5;
                        break;
                    case 2:
                        signFace = 2;
                        signBack = 3;
                        break;
                    case 3:
                        signFace = 5;
                        signBack = 4;
                        break;
                    default:
                        signFace = 3;
                        signBack = 2;
                        break;
                }

                if(side == signBack)
                {
                    short type = ((TileEntityBlockTrafficSign)tile).getSignType();
                    byte shape = ((TileEntityBlockTrafficSign)tile).getSignShape();
                    short direction = ((TileEntityBlockTrafficSign)tile).getSignDirection();
                    if(side == signBack)
                    {
                        if(type == 0)
                            return this.signBase;

                    }
                    if(shape == 5)
                    {
                        if(type < 2)
                            return this.signMiscB[1];
                        if(type >= 2 && type <= 3)
                            return this.signMiscB[2];
                        if(type >= 4 && type <= 45)
                            return this.signMiscB[3];
                        if(type >= 46 && type <= 61)
                            return this.signMiscB[4];
                        if(type == 62 && (direction == 0 || direction == 1))
                            return this.signMiscB[5];
                        if(type == 62 && (direction == 2 || direction == 3))
                            return this.Misc5Ba;
                        /*if(type == 62)
                            return this.signMiscB[5];*/
                        if(type > 62)
                            return this.signMiscB[6];
                    }
                    if(shape == 6)
                    {
                        if(type < 73)
                            return this.signLetterB[1];
                        if(type >= 73)
                            return this.signLetterB[2];
                    }
                    if(shape == 7)
                    {
                        if(type < 7)
                            return this.signTrainB[1];
                        if(type >= 7 && type <= 8)
                            return this.signTrainB[2];
                        if(type == 9)
                            return this.signTrainB[3];
                        if(type >= 10 && type <= 22)
                            return this.signTrainB[4];
                        if(type >= 23 && type <= 42)
                            return this.signTrainB[5];
                        if(type >= 43 && type <= 53)
                            return this.signTrainB[6];
                        if(type == 54)
                            return this.signTrainB[7];
                        if(type == 55)
                            return this.signTrainB[8];
                        if(type >= 56 && type <= 59)
                            return this.signTrainB[9];
                        if(type == 60)
                            return this.signTrainB[10];
                        if(type == 61)
                            return this.signTrainB[11];
                        if(type > 61)
                            return this.signTrainB[12];
                    }
                    if(shape == 8)
                    {
                        if(type < 69)
                            return this.signSpeedB[1];
                        if(type >= 69)
                            return this.signSpeedB[2];
                    }
                }
                if(side == signFace)
                {
                    short type = ((TileEntityBlockTrafficSign)tile).getSignType();
                    byte shape = ((TileEntityBlockTrafficSign)tile).getSignShape();
                    short direction = ((TileEntityBlockTrafficSign)tile).getSignDirection();
 
                    if(type == 0)
                        return this.signBase;
                /*if(shape == 5 && type == 62 && (direction == 2 || direction == 3))
                        return this.Misc62a;*/

                    switch(shape)
                    {
                        case 0:
                            return this.signSquare[type];
                        case 1:
                            return this.signCircle[type];
                        case 2:
                            return this.signTriangle[type];
                        case 3:
                            return this.signDiamond[type];
                        case 4:
                            return this.signRectangle[type];
                        case 5:
                            return this.signMisc[type];
                        case 6:
                            return this.signLetter[type];
                        case 7:
                            return this.signTrain[type];
                        case 8:
                            return this.signSpeed[type];
                        default:
                            return this.signError;
                    }
                }
            }
        }
        return this.signPost;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityBlockTrafficSign)
        {
            byte signColTop = 16;
            if(((TileEntityBlockTrafficSign)tile).getSignShape() == 5 && ((TileEntityBlockTrafficSign)tile).getSignType() > 45 && ((TileEntityBlockTrafficSign)tile).getSignType() < 62 )
                signColTop = 8;
            
            switch(((TileEntityBlockTrafficSign)tile).getSignDirection())
            {
                case 0:
                    this.minX = 0.4F;
                    this.minY = 0.0F;
                    this.minZ = 0.5F;
                    this.maxX = 0.6F;
                    this.maxY = signColTop / 16F;
                    this.maxZ = 0.65F;

                    if(world.getBlockMetadata(x, y, z) == 1)
                    {
                        this.minX = 0.0F;
                        this.maxX = 1F;
                        this.maxZ = 0.7F;
                    }
                    break;
                case 1:
                    this.minX = 0.35F;
                    this.minY = 0.0F;
                    this.minZ = 0.4F;
                    this.maxX = 0.5F;
                    this.maxY = signColTop / 16F;
                    this.maxZ = 0.6F;

                    if(world.getBlockMetadata(x, y, z) == 1)
                    {
                        this.minZ = 0.0F;
                        this.minX = 0.3F;
                        this.maxZ = 1F;
                    }
                    break;
                case 2:
                    this.minX = 0.4F;
                    this.minY = 0.0F;
                    this.minZ = 0.35F;
                    this.maxX = 0.6F;
                    this.maxY = signColTop / 16F;
                    this.maxZ = 0.5F;

                    if(world.getBlockMetadata(x, y, z) == 1)
                    {
                        this.minX = 0.0F;
                        this.maxX = 1F;
                        this.maxZ = 0.5F;
                    }
                    break;
                case 3:
                    this.minX = 0.5F;
                    this.minY = 0.0F;
                    this.minZ = 0.4F;
                    this.maxX = 0.65F;
                    this.maxY = signColTop / 16F;
                    this.maxZ = 0.6F;

                    if(world.getBlockMetadata(x, y, z) == 1)
                    {
                        this.minZ = 0.0F;
                        this.maxX = 0.7F;
                        this.maxZ = 1F;
                    }
                    break;
                default:
                    this.minX = 0.3F;
                    this.minY = 0.0F;
                    this.minZ = 0.5F;
                    this.maxX = 0.7F;
                    this.maxY = 1F;
                    this.maxZ = 0.65F;

                    if(world.getBlockMetadata(x, y, z) == 1)
                    {
                        this.minX = 0.0F;
                        this.maxX = 1F;
                        this.maxZ = 0.7F;
                    }
                    break;
            }
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntityBlockTrafficSign();
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile instanceof TileEntityBlockTrafficSign)
        {
            int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
            ((TileEntityBlockTrafficSign)tile).setSignDirection((byte)direction);
        }

    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(world.getBlockMetadata(x, y, z) == 1)
        {
            if(RoadStuffConfig.enableDebug)
            {
                System.out.println(((TileEntityBlockTrafficSign)world.getTileEntity(x, y, z)).getSignType() + ", client is " + world.isRemote);
            }
            if(!world.isRemote)
            {
                TileEntity tile = world.getTileEntity(x, y, z);
                if(tile instanceof TileEntityBlockTrafficSign)
                {
                    TileEntityBlockTrafficSign tileEntity = (TileEntityBlockTrafficSign)tile;
                    player.triggerAchievement(RoadStuffAchievements.configSign);
                    if(RoadStuffConfig.enableDebug)
                    {
                        player.addChatMessage(new ChatComponentTranslation("tile.signdirection.number", tileEntity.getSignDirection()));
                        player.addChatMessage(new ChatComponentTranslation("tile.signshape.number", tileEntity.getSignShape()));
                        player.addChatMessage(new ChatComponentTranslation("tile.signtype.number", tileEntity.getSignType()));
                    }
                }
                return true;
            }
            else
            {
                if(world.getBlockMetadata(x, y, z) != 0)
                    player.openGui(RoadStuff.instance, 0, world, x, y, z);
                return true;
            }
        }
        return false;
    }
}
