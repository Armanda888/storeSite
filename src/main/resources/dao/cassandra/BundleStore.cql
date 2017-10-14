CREATE TYPE IF NOT EXISTS bundles.Address_Type (
    id            text,
    address_one      text,
    address_two      text,
    state         text,
    city          text,
    postcode      text
);

CREATE TABLE IF NOT EXISTS bundles.User (
    id            text,
    email         text,
    password      text,
    firstName     text,
    lastName      text,
    addresses     list<frozen<Address_Type>>,
    phoneNumber   text,
    subscriber    boolean,
    orders        set<text>,
    PRIMARY KEY (id, email)
) WITH
    bloom_filter_fp_chance=0.001000 AND
        caching={'keys': 'ALL' } AND
        comment='' AND
        dclocal_read_repair_chance=0.100000 AND
        gc_grace_seconds=10800 AND
        read_repair_chance=0.050000 AND
        default_time_to_live=0 AND
        speculative_retry='99.0PERCENTILE' AND
        memtable_flush_period_in_ms=0 AND
        compaction={'class': 'LeveledCompactionStrategy'} AND
        compression={'sstable_compression': 'LZ4Compressor'};

CREATE TYPE IF NOT EXISTS bundles.Price_Type (
    price         float,
    salePrice     float,
);

CREATE TABLE IF NOT EXISTS bundles.Product (
    id            text,
    name          text,
    description   text,
    category      text,
    sizes         set<int>,
    textures      set<text>,
    colors        set<text>,
    onSale        boolean,
    prices        map<text, frozen<Price_Type>>,
    picturesLocations   set<text>,
    reviews       map<text, text>,
    PRIMARY KEY (id)
) WITH
   bloom_filter_fp_chance=0.001000 AND
       caching={'keys': 'ALL' } AND
       comment='' AND
       dclocal_read_repair_chance=0.100000 AND
       gc_grace_seconds=10800 AND
       read_repair_chance=0.050000 AND
       default_time_to_live=0 AND
       speculative_retry='99.0PERCENTILE' AND
       memtable_flush_period_in_ms=0 AND
       compaction={'class': 'LeveledCompactionStrategy'} AND
       compression={'sstable_compression': 'LZ4Compressor'};


CREATE TABLE IF NOT EXISTS bundles.Orders (
    id               text,
    items            list<text>,
    userId           text,
    address          text,
    orderDate        timestamp,
    status           text,
    PRIMARY KEY (id)
) WITH
    bloom_filter_fp_chance=0.001000 AND
        caching={'keys': 'ALL' } AND
        comment='' AND
        dclocal_read_repair_chance=0.100000 AND
        gc_grace_seconds=10800 AND
        read_repair_chance=0.050000 AND
        default_time_to_live=0 AND
        speculative_retry='99.0PERCENTILE' AND
        memtable_flush_period_in_ms=0 AND
        compaction={'class': 'LeveledCompactionStrategy'} AND
        compression={'sstable_compression': 'LZ4Compressor'};
