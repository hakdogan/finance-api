# Finance API

Java API and command line program to fetching foreign currency and precious metal rates from a public service.

This API developed with Quarkus picocli extension. [Picocli](https://picocli.info/) is an open source tool for creating rich command line applications.


## Command Line Usage
```shell script
# jvm mode
# mvn clean package
java -jar target/quarkus-app/quarkus-run.jar USD

USD {"Alış":"27,7558","Tür":"Döviz","Satış":"27,7727","Değişim":"%0,14"}

# native mode
# mvn clean package -Pnative
./target/finance-api-runner altin

gram-altin {"Alış":"1.722,53","Tür":"Altın","Satış":"1.722,80","Değişim":"%3,39"}
ceyrek-altin {"Alış":"2.839,50","Tür":"Altın","Satış":"2.904,94","Değişim":"%1,54"}
yarim-altin {"Alış":"5.661,25","Tür":"Altın","Satış":"5.809,89","Değişim":"%1,54"}
tam-altin {"Alış":"11.358,00","Tür":"Altın","Satış":"11.584,24","Değişim":"%1,54"}
cumhuriyet-altini {"Alış":"11.775,00","Tür":"Altın","Satış":"11.953,00","Değişim":"%1,42"}
ata-altin {"Alış":"11.712,93","Tür":"Altın","Satış":"12.010,65","Değişim":"%1,54"}
14-ayar-altin {"Alış":"1.011,57","Tür":"Altın","Satış":"1.012,73","Değişim":"%1,54"}
18-ayar-altin {"Alış":"1.295,52","Tür":"Altın","Satış":"1.297,01","Değişim":"%1,54"}
ikibucuk-altin {"Alış":"28.394,99","Tür":"Altın","Satış":"28.854,00","Değişim":"%1,54"}
besli-altin {"Alış":"57.499,86","Tür":"Altın","Satış":"58.631,89","Değişim":"%1,54"}
gremse-altin {"Alış":"28.394,99","Tür":"Altın","Satış":"29.049,44","Değişim":"%1,54"}
resat-altin {"Alış":"11.712,93","Tür":"Altın","Satış":"12.010,65","Değişim":"%1,54"}
hamit-altin {"Alış":"11.712,93","Tür":"Altın","Satış":"12.010,65","Değişim":"%1,54"}
```