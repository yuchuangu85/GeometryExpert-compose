// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import com.formdev.flatlaf.FlatDarculaLaf
import com.formdev.flatlaf.FlatLaf
import com.formdev.flatlaf.FlatLightLaf
import com.formdev.flatlaf.util.SystemInfo
import wprover.GExpert
import javax.swing.SwingUtilities


fun main() = SwingUtilities.invokeLater {
    setupTheme()
    GExpert.createAndShowGUI()
}

fun setupTheme() {
    // macOS
    if (SystemInfo.isMacOS) {
        // enable screen menu bar
        // (moves menu bar from JFrame window to top of screen)
        System.setProperty("apple.laf.useScreenMenuBar", "true")

        // application name used in screen menu bar
        // (in first menu after the "apple" menu)
        System.setProperty("apple.awt.application.name", "FlatLaf Demo")

        // appearance of window title bars
        // possible values:
        //   - "system": use current macOS appearance (light or dark)
        //   - "NSAppearanceNameAqua": use light appearance
        //   - "NSAppearanceNameDarkAqua": use dark appearance
        System.setProperty("apple.awt.application.appearance", "system")
    }
    // set theme like Intellij
    FlatLaf.setup(FlatLightLaf())

}