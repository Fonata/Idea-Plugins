// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.paradox.localisation.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.openapi.util.Iconable.IconFlags;
import com.windea.plugin.idea.paradox.ParadoxLocale;
import javax.swing.Icon;

public interface ParadoxLocalisationLocale extends ParadoxLocalisationNamedElement {

  @NotNull
  PsiElement getLocaleId();

  @Nullable
  String getName();

  @NotNull
  PsiElement setName(@NotNull String name);

  @NotNull
  PsiElement getNameIdentifier();

  @NotNull
  Icon getIcon(@IconFlags int flags);

  //WARNING: getReference(...) is skipped
  //matching getReference(ParadoxLocalisationLocale, ...)
  //methods are not found in ParadoxLocalisationPsiImplUtil

  @Nullable
  ParadoxLocale getParadoxLocale();

}
