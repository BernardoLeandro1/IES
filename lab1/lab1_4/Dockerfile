# syntax=docker/dockerfile:1
FROM postgres:11
LABEL author="Bernardo Leandro"

ENV POSTGRES_PASSWORD sasa
ENV POSTGRES_DB simpleDB

COPY dbscriptsOrder/ /docker-entrypoint-initdb.d/