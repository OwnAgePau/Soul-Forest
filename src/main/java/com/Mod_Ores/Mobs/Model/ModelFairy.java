package com.Mod_Ores.Mobs.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFairy extends ModelBase
{
//fields
    ModelRenderer FairyBody;
    ModelRenderer FairyWingLeftPart1;
    ModelRenderer FairyWingLeftPart2;
    ModelRenderer FairyWingRightPart1;
    ModelRenderer FairyWingRightPart2;
    ModelRenderer FairyHead;
    ModelRenderer FairyArmLeft;
    ModelRenderer FairyArmRight;
    ModelRenderer FootRightPart1;
    ModelRenderer FootRightPart2;
    ModelRenderer FootLeftPart1;
    ModelRenderer FootLeftPart2;
  
  public ModelFairy()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      FairyBody = new ModelRenderer(this, 0, 0);
      FairyBody.addBox(0F, 0F, 0F, 4, 4, 1);
      FairyBody.setRotationPoint(-1F, 0F, 0F);
      FairyBody.setTextureSize(64, 32);
      FairyBody.mirror = true;
      setRotation(FairyBody, 0F, 0F, 0F);
      FairyWingLeftPart1 = new ModelRenderer(this, 0, 5);
      FairyWingLeftPart1.addBox(0F, 0F, 0F, 2, 2, 1);
      FairyWingLeftPart1.setRotationPoint(2F, -1F, 1F);
      FairyWingLeftPart1.setTextureSize(64, 32);
      FairyWingLeftPart1.mirror = true;
      setRotation(FairyWingLeftPart1, 0F, 0F, 0F);
      FairyWingLeftPart2 = new ModelRenderer(this, 0, 5);
      FairyWingLeftPart2.addBox(0F, 0F, 0F, 2, 2, 1);
      FairyWingLeftPart2.setRotationPoint(3F, -2F, 1F);
      FairyWingLeftPart2.setTextureSize(64, 32);
      FairyWingLeftPart2.mirror = true;
      setRotation(FairyWingLeftPart2, 0F, 0F, 0F);
      FairyWingRightPart1 = new ModelRenderer(this, 0, 5);
      FairyWingRightPart1.addBox(0F, 0F, 0F, 2, 2, 1);
      FairyWingRightPart1.setRotationPoint(-2F, -1F, 1F);
      FairyWingRightPart1.setTextureSize(64, 32);
      FairyWingRightPart1.mirror = true;
      setRotation(FairyWingRightPart1, 0F, 0F, 0F);
      FairyWingRightPart2 = new ModelRenderer(this, 0, 5);
      FairyWingRightPart2.addBox(0F, 0F, 0F, 2, 2, 1);
      FairyWingRightPart2.setRotationPoint(-3F, -2F, 1F);
      FairyWingRightPart2.setTextureSize(64, 32);
      FairyWingRightPart2.mirror = true;
      setRotation(FairyWingRightPart2, 0F, 0F, 0F);
      FairyHead = new ModelRenderer(this, 10, 0);
      FairyHead.addBox(0F, 0F, 0F, 2, 2, 2);
      FairyHead.setRotationPoint(0F, -2F, -1F);
      FairyHead.setTextureSize(64, 32);
      FairyHead.mirror = true;
      setRotation(FairyHead, 0F, 0F, 0F);
      FairyArmLeft = new ModelRenderer(this, 18, 0);
      FairyArmLeft.addBox(0F, 0F, 0F, 1, 1, 3);
      FairyArmLeft.setRotationPoint(3F, 1F, -2F);
      FairyArmLeft.setTextureSize(64, 32);
      FairyArmLeft.mirror = true;
      setRotation(FairyArmLeft, 0F, 0F, 0F);
      FairyArmRight = new ModelRenderer(this, 18, 0);
      FairyArmRight.addBox(0F, 0F, 0F, 1, 1, 3);
      FairyArmRight.setRotationPoint(-2F, 1F, -2F);
      FairyArmRight.setTextureSize(64, 32);
      FairyArmRight.mirror = true;
      setRotation(FairyArmRight, 0F, 0F, 0F);
      FootRightPart1 = new ModelRenderer(this, 10, 4);
      FootRightPart1.addBox(0F, 0F, 0F, 1, 3, 1);
      FootRightPart1.setRotationPoint(-1F, 3F, -1F);
      FootRightPart1.setTextureSize(64, 32);
      FootRightPart1.mirror = true;
      setRotation(FootRightPart1, 0F, 0F, 0F);
      FootRightPart2 = new ModelRenderer(this, 6, 6);
      FootRightPart2.addBox(0F, 0F, 0F, 1, 1, 1);
      FootRightPart2.setRotationPoint(-1F, 6F, -2F);
      FootRightPart2.setTextureSize(64, 32);
      FootRightPart2.mirror = true;
      setRotation(FootRightPart2, 0F, 0F, 0F);
      FootLeftPart1 = new ModelRenderer(this, 10, 4);
      FootLeftPart1.addBox(0F, 0F, 0F, 1, 3, 1);
      FootLeftPart1.setRotationPoint(2F, 3F, -1F);
      FootLeftPart1.setTextureSize(64, 32);
      FootLeftPart1.mirror = true;
      setRotation(FootLeftPart1, 0F, 0F, 0F);
      FootLeftPart2 = new ModelRenderer(this, 6, 6);
      FootLeftPart2.addBox(0F, 0F, 0F, 1, 1, 1);
      FootLeftPart2.setRotationPoint(2F, 6F, -2F);
      FootLeftPart2.setTextureSize(64, 32);
      FootLeftPart2.mirror = true;
      setRotation(FootLeftPart2, 0F, 0F, 0F);
      this.FairyBody.addChild(this.FairyWingRightPart1);
      this.FairyBody.addChild(this.FairyWingLeftPart1);
      this.FairyWingRightPart1.addChild(this.FairyWingRightPart2);
      this.FairyWingLeftPart1.addChild(this.FairyWingLeftPart2);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    FairyBody.render(f5);
    FairyWingLeftPart1.render(f5);
    FairyWingLeftPart2.render(f5);
    FairyWingRightPart1.render(f5);
    FairyWingRightPart2.render(f5);
    FairyHead.render(f5);
    FairyArmLeft.render(f5);
    FairyArmRight.render(f5);
    FootRightPart1.render(f5);
    FootRightPart2.render(f5);
    FootLeftPart1.render(f5);
    FootLeftPart2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(Entity par7Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	/*EntityIceFairy entitybat = (EntityIceFairy)par7Entity;
    this.FairyHead.rotateAngleX = par6 / (180F / (float)Math.PI);
    this.FairyHead.rotateAngleY = par5 / (180F / (float)Math.PI);
    this.FairyHead.rotateAngleZ = 0.0F;
    this.FairyHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.FairyWingRightPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.FairyWingLeftPart1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.FairyBody.rotateAngleX = ((float)Math.PI / 4F) + MathHelper.cos(par4 * 0.1F) * 0.15F;
    this.FairyBody.rotateAngleY = 0.0F;
    this.FairyWingRightPart1.rotateAngleY = MathHelper.cos(par4 * 1.3F) * (float)Math.PI * 0.25F;
    this.FairyWingLeftPart1.rotateAngleY = -this.FairyWingRightPart1.rotateAngleY;
    this.FairyWingRightPart2.rotateAngleY = this.FairyWingRightPart1.rotateAngleY * 0.5F;
    this.FairyWingLeftPart2.rotateAngleY = -this.FairyWingRightPart1.rotateAngleY * 0.5F;
    
    this.FairyHead.render(par7);
    this.FairyBody.render(par7);*/
  }

}
