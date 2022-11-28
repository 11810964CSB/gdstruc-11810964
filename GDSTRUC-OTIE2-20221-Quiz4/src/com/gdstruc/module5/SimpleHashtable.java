package com.gdstruc.module5;

public class SimpleHashtable {
    private StoredPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        // applied linear probing
        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            // hashedkey is pointing at the last element
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            // search the array for the next immediate vacant position
            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        }
        else {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public void remove(String key, Player value) {
        int hashedKey = hashKey(key);

        // 11810964: this is the man we're looking for, chief. he fits the description! he's got six letters in his name
        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key) && hashtable[hashedKey].getValue().equals(value)) {
            hashtable[hashedKey] = null;
            System.out.println("Removed " + hashedKey);
        }

        // 11810964: *flicks lighter* celebi's not our man, lieutenant, just because he's got six letters; we're looking for a guy named mankey...

        // linear probing goes here
        if (isOccupied(hashedKey)) {

            // searches the array for the same value
            while (hashtable[hashedKey].getValue() != value) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
            hashtable[hashedKey] = null;
            System.out.println("Removed " + hashedKey);
        }
    }
    public int findKey(String key) {
        int hashedKey = hashKey(key);

        // found the right key?
        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return  hashedKey;
        }

        // applied linear probing
        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            // hashedkey is pointing at the last element
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            // search the array for the next immediate vacant position
            while (hashedKey != stoppingIndex &&
                    isOccupied(hashedKey) &&
                    !hashtable[hashedKey].getKey().equals(key)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        // return the index that corresponds to the key if applicable
        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return  null;
        }

        return hashtable[hashedKey].getValue();
    }

    public boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + " " + hashtable[i].getValue());
            }
            else {
                System.out.println("Element " + i + " null");
            }
        }
    }
}
