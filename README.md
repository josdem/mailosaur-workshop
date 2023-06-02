Mailosaur Workshop
----------------------------------------

This project shows how to use [Mailosaur](https://mailosaur.com/) for end-to-end testing

#### To test the project with Gradle

```bash
gradle test -DmailosaurApiKey=${mailosaurApiKey} -DmailosaurServerId=${mailosaurServerId}
```

where:
```bash
 - ${mailosaurApiKey} Is the Mailosaur API Key
 - ${mailosaurServerId} Is the Mailosaur Server Id
```

#### Read this as reference

* https://josdem.io/techtalk/java/mailosaur_getting_started/
* https://josdem.io/techtalk/java/junit5/