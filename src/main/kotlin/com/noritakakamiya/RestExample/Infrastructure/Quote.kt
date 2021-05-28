package com.noritakakamiya.RestExample.Infrastructure
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(val type: String, val value: Value) {
    override fun toString(): String {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Value {
    var id: Long? = null
    var quote: String? = null

    override fun toString(): String {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}'
    }
}
