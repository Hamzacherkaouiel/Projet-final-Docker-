# Projet Final Docker - Application 3-Tier Cloud Native

Une application web simple à 3 niveaux (3-tier) containerisée avec Docker et déployée localement avec Kubernetes.

## 🏗️ Architecture

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Frontend      │    │    Backend      │    │    Database     │
│   (React/HTML)  │◄──►│   (Node.js/     │◄──►│   (MySQL/       │
│   Port: 3000    │    │    Python)      │    │    PostgreSQL)  │
│                 │    │   Port: 8000    │    │   Port: 5432    │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

## 🚀 Composants

### Tier 1 - Frontend (Présentation)
- Interface utilisateur web
- Technologies: React, HTML/CSS/JavaScript
- Port: 3000

### Tier 2 - Backend (Logic Métier)
- API REST
- Technologies: Node.js, Express ou Python Flask
- Port: 8000

### Tier 3 - Database (Données)
- Base de données relationnelle
- Technologies: MySQL ou PostgreSQL
- Port: 5432/3306

## 📋 Prérequis

- **Docker** et **Docker Compose** installés
- **Kubernetes** (minikube ou Docker Desktop avec Kubernetes)
- **kubectl** CLI
- **Git** pour cloner le repository

## 🚦 Démarrage Rapide

### 1. Cloner le Repository
```bash
git clone https://github.com/Hamzacherkaouiel/Projet-final-Docker-.git
cd Projet-final-Docker-
```

### 2. Déploiement avec Docker Compose (Développement)
```bash
# Construire et démarrer tous les services
docker-compose up --build

```

### 3. Déploiement avec Kubernetes (Local)
```bash
minikube start

kubectl apply -f backend/

kubectl get pods
kubectl get services

kubectl port-forward service/frontend-service 3000:3000
```



## 🐳 Docker Compose

### Utilisation
```bash

docker-compose up

docker-compose down

docker-compose build



docker-compose restart [service-name]
```

### Services Configurés
- **frontend**: Interface utilisateur React/HTML
- **backend**: API REST Node.js/Python
- **database**: Base de données MySQL/PostgreSQL
- **volumes**: Persistance des données

## ☸️ Kubernetes

### Commandes Utiles
```bash
kubectl apply -f k8s/

kubectl get pods


kubectl get services

kubectl logs -f deployment/backend-deployment

kubectl port-forward service/frontend-service 3000:3000
kubectl port-forward service/backend-service 8000:8000

# Supprimer tous les resources
kubectl delete -f backend/
```

### Services Exposés
- **Frontend**: NodePort 30000 ou LoadBalancer
- **Backend**: ClusterIP avec port-forward
- **Database**: ClusterIP (accès interne uniquement)



## 🔄 Workflow de Développement

1. **Modification du code** dans `frontend/` ou `backend/`
2. **Reconstruction des images** : `docker-compose build`
3. **Redémarrage des services** : `docker-compose up`
4. **Test des changements** via l'interface web
5. **Déploiement Kubernetes** : `kubectl apply -f k8s/`

## 🎯 Fonctionnalités

- ✅ Architecture 3-tier séparée
- ✅ Containerisation avec Docker
- ✅ Orchestration avec Kubernetes
- ✅ Persistence des données
- ✅ API REST complète
- ✅ Interface utilisateur responsive




**Hamza Cherkaouiel**
- GitHub: [@Hamzacherkaouiel](https://github.com/Hamzacherkaouiel)
- Repository: [Projet-final-Docker-](https://github.com/Hamzacherkaouiel/Projet-final-Docker-.git)

---

**Note**: Ce projet démontre une architecture cloud native simple avec des technologies modernes de containerisation et d'orchestration.
