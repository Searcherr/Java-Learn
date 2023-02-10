package org.example;

import lombok.Data;
import lombok.NonNull;

import java.nio.file.LinkPermission;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
public class MergeListsToUniqueList {

    private @NonNull Collection<Integer> inputUniqueElements;

    public MergeListsToUniqueList(){
        this.inputUniqueElements = new HashSet<Integer>(inputUniqueElements);
    }

    public void printValues(){
        System.out.println(inputUniqueElements);
    }
}
