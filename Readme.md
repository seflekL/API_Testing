# 🌐 API Testing Practice

**API Testing Practice** projesi, çeşitli HTTP istek türlerini ve JSON ile çalışma yöntemlerini öğrenmek ve uygulamak için oluşturulmuştur. Bu proje, farklı API test senaryolarını kapsayan Java dosyalarını içermektedir ve API test süreçlerini anlamayı kolaylaştırmayı hedefler.

---

## 📂 Proje Yapısı

### GET İstekleri
- **`C01_GetRequest_ResponseBodyYazdirma.java`**: GET isteği göndererek yanıt gövdesini yazdırma.
- **`C02_GetRequest_ResposeBilgileriManuelTestEdilmesi.java`**: Yanıt bilgilerini manuel test etme.
- **`C03_Get_ResponseDegerleriniOtomasyonileTestEtme.java`**: Yanıt değerlerini otomasyon ile doğrulama.
- **`C07_Get_ResponseBodyTesti.java`**: Yanıt gövdesi üzerinde otomatik testler.
- **`C13_Get_ExpectedDataOlusturma.java`**: Beklenen yanıt verilerini oluşturup test etme.

### POST İstekleri
- **`C08_Post_ResponseBodyTesti.java`**: POST isteği ile gönderilen verilerin doğruluğunu test etme.
- **`C14_Post_ExpectedDataVeJsonPathIleAssertion.java`**: Beklenen veri ve JsonPath ile doğrulama.
- **`C27_Post_TestDataKullanimi.java`**: Test Data Class kullanarak POST testleri.

### PUT İstekleri
- **`C06_Put_RespnseBilgileriAssertion.java`**: PUT isteği ile yanıt bilgilerini doğrulama.
- **`C31_Put_PojoClass.java`**: Pojo Class kullanarak veri güncelleme ve doğrulama.

### JSON ve JSONPath Kullanımı
- **`C04_JsonObjesiOlusturma.java`**: JSON objeleri oluşturma.
- **`C10_JsonPathKullanimi.java`**: Yanıt gövdesinde belirli verileri bulma ve doğrulama.

---

## 🚀 Kurulum ve Kullanım

1. **Depoyu Klonlayın**
   ```bash
   git clone https://github.com/seflekL/API_Testing.git
   cd API_Testing
Maven Bağımlılıklarını Yükleyin

bash
Copy code
mvn clean install
Testleri Çalıştırın

bash
Copy code
mvn test
🛠️ Kullanılan Teknolojiler
Java: Testlerin temel programlama dili.
RestAssured: HTTP isteklerini göndermek ve yanıtları doğrulamak için.
TestNG: Testleri organize etmek ve çalıştırmak için.
Pojo: Veri yapıları için.
JSON ve JsonPath: API yanıtlarını işlemek için.
🌟 Özellikler
Farklı HTTP istek türleri (GET, POST, PUT) ile test senaryoları.
Pojo ve JSON kullanımı ile esnek veri işleme.
Otomatik ve manuel test doğrulama örnekleri.
🤝 Katkıda Bulunun
Projeye katkıda bulunmak isterseniz:

Depoyu fork'layın.
Yeni bir dal oluşturun: git checkout -b yeni-ozellik.
Değişikliklerinizi commit edin: git commit -m "Yeni özellik eklendi".
Dalınızı push edin: git push origin yeni-ozellik.
Bir Pull Request gönderin.
📄 Lisans
Bu proje, eğitim ve kişisel gelişim amacıyla hazırlanmıştır.

🌟 Teşekkürler!
Bu projeyi desteklediğiniz için teşekkür ederiz! 🎉
Herhangi bir sorunuz varsa seflekL ile iletişime geçebilirsiniz. 🙌
