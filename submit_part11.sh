#!/bin/bash

echo "Starting submission for part 11 exercises..."
for d in part11*; do
  if [ -d "$d" ]; then
    echo "Submitting $d..."
    (cd "$d" && yes n | tmc submit)
  fi
done
echo "Finished submitting part 11!"
