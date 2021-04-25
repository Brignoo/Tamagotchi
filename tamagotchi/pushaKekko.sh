#!/bin/bash

echo ""
echo "Quali file vuoi aggiungere (. per aggiungere tutti i file modificati)? "
read file_add

echo ""
echo "Inserire messaggio per il commit: "
read commit_message

git add $file_add
git commit -m "$commit_message"
git push -u origin master