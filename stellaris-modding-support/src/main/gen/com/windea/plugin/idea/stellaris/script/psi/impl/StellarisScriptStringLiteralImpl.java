// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.stellaris.script.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.windea.plugin.idea.stellaris.script.psi.StellarisScriptTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.windea.plugin.idea.stellaris.script.psi.*;
import com.intellij.openapi.util.Iconable.IconFlags;
import com.intellij.psi.PsiReference;
import javax.swing.Icon;

public class StellarisScriptStringLiteralImpl extends ASTWrapperPsiElement implements StellarisScriptStringLiteral {

  public StellarisScriptStringLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull StellarisScriptVisitor visitor) {
    visitor.visitStringLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StellarisScriptVisitor) accept((StellarisScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

  @Override
  @Nullable
  public PsiElement getUnquotedString() {
    return findChildByType(UNQUOTED_STRING);
  }

  @Override
  @NotNull
  public PsiReference getReference() {
    return StellarisScriptPsiImplUtil.getReference(this);
  }

  @Override
  @Nullable
  public Icon getIcon(@IconFlags int flags) {
    return StellarisScriptPsiImplUtil.getIcon(this, flags);
  }

  @Override
  @Nullable
  public String getValue() {
    return StellarisScriptPsiImplUtil.getValue(this);
  }

}
