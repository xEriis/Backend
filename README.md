# 📦 Product Service

**Puerto:** `8080`
**Base de Datos:** `db_product`

Utilizado para la gestión del catálogo (productos), categorías y control de inventario (stock). 

## 🛠️ Base de Datos
```sql
CREATE DATABASE db_product; -- Para productos y categorías
```

---
### 🔗 Mapa de Arquitectura
0. [Config data](https://github.com/AlexaRamirezV/config-data.git)
1.  [Config Server](https://github.com/AlexaRamirezV/config-service.git)
2.  [Registry Service (Eureka)](https://github.com/AlexaRamirezV/registry-service.git)
3.  [Gateway Service](https://github.com/AlexaRamirezV/gateway-service.git)
4.  [Admin Service](https://github.com/AlexaRamirezV/admin-service.git)
5.  APIs del sistema:
   * [Auth](https://github.com/AlexaRamirezV/DWB-auth.git)
   * [Customer](https://github.com/AlexaRamirezV/DWB-customer.git)
   * ➡️ **[Product]**
   * [Invoice](https://github.com/AlexaRamirezV/DWB-invoice.git)
