package com.openkey.setups;

import io.cucumber.plugin.Plugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsHandler implements Plugin {

  private static Logger logger =LogManager.getLogger(LogsHandler.class);

  public static void infoLogs (String msg)
  {
      logger.info(msg);
  }

    public static void warnLogs (String msg)
    {
        logger.warn(msg);
    }

    public static void errorLogs (String msg)
    {
        logger.error(msg);
    }

    public static void fatalLogs (String msg)
    {
        logger.fatal(msg);
    }

    public static void debugLogs (String msg)
    {
        logger.debug(msg);
    }
}
