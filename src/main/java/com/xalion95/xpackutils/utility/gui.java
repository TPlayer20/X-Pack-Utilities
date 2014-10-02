package com.xalion95.xpackutils.utility;

import javax.swing.*;

public class gui {

    public static void setDefaultLookAndFeel(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e){
        } catch (ClassNotFoundException e){
        } catch (InstantiationException e){
        } catch (IllegalAccessException e){
        }
    }
}
