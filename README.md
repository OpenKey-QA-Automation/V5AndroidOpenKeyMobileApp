# OpenKeyMobileApp
OpenKey Mobile App Automation Base Framework

- Pull the Code from Master Branch
- Change Device Name, OS Version in envds.yaml file according to your Android Mobile device
- Change appPackage and appActivity in envds.yaml file according to OpenKey Android Mobile App using for the Automation Test Suit
- Change Country Code in selectCountryCode method and Mobile Number in enterMobileNumber method in OpenKeyLoginScreen.java class
- Change Selectors roomIdDropdown, guestNameAdded and guestMobileNumberAdded in HostPortalCreateSessionScreen.java class
- Change value of room number, country code and phone number in HostPortalCreateSessionScreen.java class
  - wait.until(ExpectedConditions.visibilityOfElementLocated(roomId)).sendKeys("800");
  - wait.until(ExpectedConditions.visibilityOfElementLocated(cntryCode)).sendKeys("+91");
  - wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberForSearch)).sendKeys("9168515566");
- Change in HostPortalLoginScreen.java class login credentials 
  - wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys("mrajgor@openkey.co"); 
  - wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("****");

