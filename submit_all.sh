#!/bin/bash

echo "Starting submission of all exercises..."
for d in part*; do
  if [ -d "$d" ]; then
    echo "Submitting $d..."
    (cd "$d" && tmc submit)
  fi
done
echo "Finished submitting all exercises!"
