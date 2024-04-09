FROM node:16-alpine as build
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
CMD ["npm", "run", "start:dev"]

# docker build -t nestjs .
# docker run -p -d 3000:3000 nestjs
