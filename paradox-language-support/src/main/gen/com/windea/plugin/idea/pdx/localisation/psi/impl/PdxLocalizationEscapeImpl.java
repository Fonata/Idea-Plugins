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

public class StellarisLocalizationEscapeImpl extends StellarisLocalizationRichTextImpl implements StellarisLocalizationEscape {

  public StellarisLocalizationEscapeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull StellarisLocalizationVisitor visitor) {
    visitor.visitEscape(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StellarisLocalizationVisitor) accept((StellarisLocalizationVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getInvalidEscapeToken() {
    return findChildByType(INVALID_ESCAPE_TOKEN);
  }

  @Override
  @Nullable
  public PsiElement getValidEscapeToken() {
    return findChildByType(VALID_ESCAPE_TOKEN);
  }

}
