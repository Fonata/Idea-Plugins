// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.pdx.localisation.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.windea.plugin.idea.pdx.localisation.psi.PdxLocalisationTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.windea.plugin.idea.pdx.localisation.psi.*;

public class PdxLocalisationPropertyValueImpl extends ASTWrapperPsiElement implements PdxLocalisationPropertyValue {

  public PdxLocalisationPropertyValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PdxLocalisationVisitor visitor) {
    visitor.visitPropertyValue(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PdxLocalisationVisitor) accept((PdxLocalisationVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PdxLocalisationRichText> getRichTextList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PdxLocalisationRichText.class);
  }

}
