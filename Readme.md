# API Testing Practice

Bu proje, çeşitli HTTP istek türleri ve JSON ile çalışarak API testlerini öğrenmek ve uygulamak için oluşturulmuş bir dizi Java dosyasını içerir. Proje, farklı API test senaryolarını kapsayan dosyalar ile API test süreçlerini anlamayı kolaylaştırmayı hedefler.

## Dosya İçeriği

### GET İstekleri

- **C01_GetRequest_ResponseBodyYazdirma.java**: `GET` isteği gönderip yanıt gövdesini yazdırmayı öğrenmek için örnek bir test içerir.
- **C02_GetRequest_ResposeBililerininManuelTestEdilmesi.java**: Yanıt bilgilerini manuel olarak test etmek için `GET` isteği örneği içerir.
- **C03_Get_ResponseDegerleriniOtomasyonileTestEtme.java**: Yanıt değerlerinin otomasyon ile doğrulanmasını gösterir.
- **C07_Get_ResponseBodyTesti.java**: `GET` isteğinin yanıt gövdesi üzerinde otomatik testler yapılır.
- **C09_Get_BodyTekrarlardanKurtulma.java**: Yanıt gövdesini daha verimli ve tekrarsız bir şekilde test etmek için örnek içerir.
- **C12_Get_ResponseBodyTestiListKullanimi.java**: Yanıt gövdesinde liste veri tiplerini kullanarak test yapmayı gösterir.
- **C13_Get_ExpectedDataOlusturma.java**: Beklenen yanıt verilerini oluşturup test etmek için örnek içerir.
- **C15_Get_SoftAssertIleExpectedDataTesti.java**: `Soft Assert` kullanarak `GET` yanıtının beklenen verilerle uyumunu test etmeyi gösterir.

### POST İstekleri

- **C08_Post_ResponseBodyTesti.java**: `POST` isteği ile gönderilen verilerin yanıt gövdesinde doğru olup olmadığını test eder.
- **C11_Post_JsonPathIleBodyTesti.java**: `JsonPath` kullanarak `POST` isteğinde yanıt gövdesi test edilir.
- **C14_Post_ExpectedDataVeJsonPathIleAssertion.java**: Beklenen veri ve `JsonPath` ile yanıt doğrulaması yapılır.
- **C27_Post_TestDataKullanimi.java**: `Test Data Class` kullanarak `POST` isteğinde test verisi oluşturur.
- **C32_POST_PojoClass.java**: `POST` istekleri için `Pojo Class` kullanarak veri gönderir ve doğrulama yapar.

### PUT İstekleri

- **C06_Put_RespnseBilgileriAssertion.java**: `PUT` isteği ile yanıt bilgilerini doğrulama işlemlerini içerir.
- **C16_Put_SoftAssertIleExpectedDataTesti.java**: `Soft Assert` ile `PUT` isteği yanıtını doğrulama işlemleri yapılır.
- **C25_Put_TestDataClassKullanimi.java**: `PUT` isteği için test verisi sınıfı kullanımı ile ilgili örnek içerir.
- **C28_Put_DeSerializationMap.java**: Yanıtın `Map` kullanılarak deserialization ile doğrulanmasını gösterir.
- **C31_Put_PojoClass.java**: `Pojo Class` kullanarak `PUT` isteklerinde veri güncellemeleri yapılır ve doğrulanır.

### JSON ve JSONPath Kullanımı

- **C04_JsonObjesiOlusturma.java** ve **C05_JsonObjesiOlusturma.java**: JSON objeleri oluşturarak istek gönderimi yapılır.
- **C10_JsonPathKullanimi.java**: `JsonPath` ile yanıt gövdesinde belirli verilerin bulunması ve doğrulanması.
- **C20_BaseUrlHeroKuapp2.java**: `Herokuapp` API taban URL kullanımıyla ilgili örnek içerir.
- **C30_DeSerializationHerOkuApp.java**: `Herokuapp` API yanıtlarını deserialization ile nesneye dönüştürme işlemleri içerir.

### BaseURL ve Test Data Kullanımı

- **C17_BaseUrlDummyRestapi.java**, **C19_BasUrlHerokuapp.java**, **C21_BaseUrlHerokuappQueryParam.java** ve **C22_BaseUrlHerokuappQueryParam.java**: `Base URL` yapılandırması ve sorgu parametreleriyle test yapma örnekleri.
- **C23_Get_TestDataClassKullanimi.java**, **C24_Get_TestDataClassKullanimi.java**: `Test Data Class` kullanarak farklı GET isteklerinde veri sağlama ve doğrulama.
  
### Pojo ve Deserialization

- **C28_Put_DeSerializationMap.java**: `Map` kullanarak `PUT` isteği yanıtının deserialization işlemi.
- **C31_Put_PojoClass.java** ve **C32_POST_PojoClass.java**: `Pojo Class` ile `PUT` ve `POST` isteklerinde veri işlemleri.

### Ekstra Dosya

- **PojoSchema.png**: Pojo sınıfı yapısını ve JSON şemasını görsel olarak gösteren bir şema dosyasıdır.

## Kullanım

1. Bu dosyaları kullanarak API testleri oluşturabilir, veri gönderme, güncelleme ve doğrulama işlemlerini deneyebilirsiniz.
2. `RestAssured` kütüphanesi kullanılarak oluşturulmuş bu testler, çeşitli HTTP istek türleri ve doğrulama teknikleri üzerinde pratik yapmanızı sağlar.

## Lisans

Bu proje, öğrenim ve kişisel gelişim amacıyla hazırlanmıştır.
