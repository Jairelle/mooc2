#!/bin/bash

echo "Starting submission for part 12 exercises..."
for d in part12*; do
  if [ -d "$d" ]; then
    echo "Submitting $d..."
    (cd "$d" && yes n | tmc submit)
  fi
done
echo "Finished submitting part 12!"
