package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    /* @Qualifier : 여러 개의 빈 객체 중 특정 빈 객체를 이름으로 지정하는 어노테이션
   (@Primary 보다 우선시 된다.)
    * */

    /* 1. 필드주입 */
//    @Autowired
//    @Qualifier("charmander")
//    private Pokemon pokemon;

    /* 2. 생성자주입 */
    private Pokemon pokemon;

    public PokemonService(@Qualifier("charmander") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack(){
        pokemon.attack();
    }
}
