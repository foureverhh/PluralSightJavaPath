package map_filter_reduce_part4;

import java.util.List;
import java.util.function.BinaryOperator;

interface Reduction<T>{
    T reduce(List<T> list, T baseIdentity, BinaryOperator<T> bo);
}
