package presentation.menu;

import presentation.UiBase;

public abstract class MenuBase extends UiBase {
    protected static final String ACTION_CHOOSE_OPTION = "Select any option %d - %d";
    protected final String[] OPTIONS;
    protected Runnable[] onOptionCallbacks;
    protected boolean isAlive;

    public MenuBase(String[] OPTIONS, Runnable[] onOptionCallbacks) {
        this.OPTIONS = OPTIONS;
        this.onOptionCallbacks = onOptionCallbacks;
        if (OPTIONS.length != onOptionCallbacks.length) throw new IllegalStateException("Each option must have callback");
        isAlive = true;
    }

    /**
     * Constructs a MenuBase object with given options.
     * Note: This constructor requires setting OPTIONS after initiating.
     * @see #setOptionCallbacks(Runnable[])
     *
     * @param OPTIONS The array of options for the menu.
     */
    public MenuBase(String[] OPTIONS) {
        this.OPTIONS = OPTIONS;
        isAlive = true;
    }

    protected void setOptionCallbacks(Runnable[] callbacks) {
        this.onOptionCallbacks = callbacks;
    }

    protected void performAction(int optionNumber) {
        try {
            onOptionCallbacks[optionNumber].run();
        } catch (Exception e) {
            onUnhandledAction(optionNumber);
        }
    }

    protected void onUnhandledAction(int optionNumber) {

    }

    protected boolean validateOption(int given, int total) {
        return (given >= 1 && given <= total);
    }

    protected void create() {

    }

    protected void destroy() {
        isAlive = false;
    }
}
