package com.vladiscrafter.ponderfului.config;

import net.createmod.catnip.config.ConfigBase;
import net.createmod.catnip.config.ui.ConfigAnnotations;

public class PonderfulUIClient extends PonderfulUIConfigBase {

    public final ConfigBool testBoolConfig = b(true, "Test Bool Config", "A test Bool config that does nothing.");
    public final ConfigInt testIntConfig = i(42, 0, 64, "Test Int Config", "A test Int config that does nothing.");

    @Override public String getName() { return "client"; }
}
