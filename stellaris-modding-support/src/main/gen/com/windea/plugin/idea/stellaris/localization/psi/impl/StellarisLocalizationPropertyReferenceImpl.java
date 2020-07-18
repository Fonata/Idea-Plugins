// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.stellaris.localization.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationTypes.*;
import com.windea.plugin.idea.stellaris.localization.psi.*;

public class StellarisLocalizationPropertyReferenceImpl extends StellarisLocalizationNamedElementImpl implements StellarisLocalizationPropertyReference {

  public StellarisLocalizationPropertyReferenceImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull StellarisLocalizationVisitor visitor) {
    visitor.visitPropertyReference(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StellarisLocalizationVisitor) accept((StellarisLocalizationVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getKeyToken() {
    return findNotNullChildByType(KEY_TOKEN);
  }

  @Override
  @Nullable
  public String getName() {
    return StellarisLocalizationPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String name) {
    return StellarisLocalizationPsiImplUtil.setName(this, name);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return StellarisLocalizationPsiImplUtil.getNameIdentifier(this);
  }

}
