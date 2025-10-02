# Stage 1: build Angular
FROM node:20-alpine AS build
WORKDIR /app

# Copiar solo package.json y package-lock.json
COPY package*.json ./
RUN npm install

# Copiar el resto del código Angular
COPY . ./

# Build Angular
RUN npm run build:test

# Stage 2: servir con Nginx
FROM nginx:alpine
COPY --from=build /app/dist/employee-management-frontend /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]