// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.paradox.localisation.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.windea.plugin.idea.paradox.ParadoxColor;

public interface ParadoxLocalisationColorfulText extends ParadoxLocalisationRichText, ParadoxLocalisationNamedElement {

  @NotNull
  List<ParadoxLocalisationRichText> getRichTextList();

  @Nullable
  PsiElement getColorCode();

  @Nullable
  String getName();

  @NotNull
  PsiElement setName(@NotNull String name);

  @Nullable
  PsiElement getNameIdentifier();

  int getTextOffset();

  @Nullable
  ParadoxColor getParadoxColor();

  //WARNING: getReference(...) is skipped
  //matching getReference(ParadoxLocalisationColorfulText, ...)
  //methods are not found in ParadoxLocalisationPsiImplUtil

}
