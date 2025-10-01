#!/bin/bash
echo "🧹 Deteniendo contenedores..."
docker-compose down -v --remove-orphans