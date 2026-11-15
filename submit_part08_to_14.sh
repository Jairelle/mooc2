#!/bin/bash

echo "Starting submission of exercises for parts 8 to 14..."
for d in part08-* part09-* part10-* part11-* part12-* part13-* part14-*; do
  if [ -d "$d" ]; then
    echo "Submitting $d..."
    (cd "$d" && tmc submit)
  fi
done
echo "Finished submitting parts 8 to 14!"
