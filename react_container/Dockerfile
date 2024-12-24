FROM node:20-alpine AS build
WORKDIR /app
COPY package.json package-lock.json ./ 
RUN npm install
COPY . .

RUN npm run build
FROM nginx:alpine AS production

RUN apk --no-cache add curl=8.11.1-r0

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

RUN mkdir -p /var/cache/nginx/client_temp && \
    chown -R appuser:appgroup /var/cache/nginx

RUN sed -i 's|/var/run/nginx.pid|/tmp/nginx.pid|' /etc/nginx/nginx.conf

COPY ./default.conf /etc/nginx/conf.d/default.conf

COPY --from=build /app/dist /usr/share/nginx/html

RUN chown -R appuser:appgroup /usr/share/nginx/html

EXPOSE 80

USER appuser

CMD ["nginx", "-g", "daemon off;"]
