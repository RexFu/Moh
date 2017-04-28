package com.rex.td_http.config;

/**
 * Created by Rex.wang on 2016/4/7
 * E-mail:WWF1116@163.com
 */

public enum DataState {

    /*
     * 数据操作码
     * 始终不缓存，只读取网络数据--成功获取只发生在网络上获取到 目标数据(真正需要的数据) 时
     */
    NO_CACHE,


    /*  默认优先读取缓存，缓存没有才联网获取数据，获得目标数据后，缓存
   成功获取 既可以发生在联网获取最新数据时，也可发生在读取到缓存时
    */
    CACHE_FIRST,


    /*默认获取网络最新数据，若没有得到目标数据，才读取缓存，缓存没有，则获取不到目标数据
   若网络有目标数据，则返回，并全部更新缓存  ---成功获取只发生在联网得到目标数据时*/
    NET_FIRST,


    /* 缓存，下拉刷新，必须联网获取目标数据，若没有目标数据，则刷新失败
          * 若有目标数据，则返回目标数据，并以全部更新的形式更新缓存
           * --成功获取只发生在联网获得目标数据时*/
    HEAD_REFRESH,



    /* 缓存，加载更多，必须联网获取目标数据，若没有目标数据，则刷新失败
        * 若有目标数据，则返回目标数据，默认不缓存(必要时以尾部增加的形式更新缓存)
         * --成功获取只发生在联网获得目标数据时*/
    LOAD_MORE
}
