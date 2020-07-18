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
import com.intellij.openapi.util.Iconable.IconFlags;
import javax.swing.Icon;

public class StellarisLocalizationPropertyHeaderImpl extends StellarisLocalizationNamedElementImpl implements StellarisLocalizationPropertyHeader {

  public StellarisLocalizationPropertyHeaderImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull StellarisLocalizationVisitor visitor) {
    visitor.visitPropertyHeader(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StellarisLocalizationVisitor) accept((StellarisLocalizationVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getHeaderToken() {
    return findNotNullChildByType(HEADER_TOKEN);
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

  @Override
  @Nullable
  public Icon getIcon(@IconFlags int flags) {
    return StellarisLocalizationPsiImplUtil.getIcon(this, flags);
  }

  @Override
  public boolean isValid() {
    return StellarisLocalizationPsiImplUtil.isValid(this);
  }

}
